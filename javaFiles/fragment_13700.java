package psq;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    int[] genData (int len) {
        Random r = new Random();
        int[] newData = new int[len];
        for (int i = 0; i < newData.length; i++) {
            newData[i] = r.nextInt();
        }
        return newData;
    }      

    boolean check (int[] arr) {
        if (arr.length == 0) {
            return true;
        }
        int lastValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //System.out.println(arr[i]);
            if (arr[i] < lastValue) {
                return false;
            }
            lastValue = arr[i];
        }
        return true;
    }

    int partition (int[] arr, int left, int right, int pivotIndex) {
        // pivotValue := array[pivotIndex]
        int pivotValue = arr[pivotIndex];
        {
            // swap array[pivotIndex] and array[right] // Move pivot to end
            int t = arr[pivotIndex];
            arr[pivotIndex] = arr[right];
            arr[right] = t;
        }
        // storeIndex := left
        int storeIndex = left;
        // for i  from  left to right - 1 // left ≤ i < right
        for (int i = left; i < right; i++) {
            //if array[i] ≤ pivotValue
            if (arr[i] <= pivotValue) {
                //swap array[i] and array[storeIndex]
                //storeIndex := storeIndex + 1            
                int t = arr[i];
                arr[i] = arr[storeIndex];
                arr[storeIndex] = t;
                storeIndex++;                   
            }
        }
        {
            // swap array[storeIndex] and array[right] // Move pivot to its final place
            int t = arr[storeIndex];
            arr[storeIndex] = arr[right];
            arr[right] = t;
        }
        // return storeIndex
        return storeIndex;
    }

    void quicksort (int[] arr, int left, int right) {
        // if right > left
        if (right > left) {            
            // select a pivot index //(e.g. pivotIndex := left + (right - left)/2)
            int pivotIndex = left + (right - left) / 2;
            // pivotNewIndex := partition(array, left, right, pivotIndex)
            int pivotNewIndex = partition(arr, left, right, pivotIndex);
            // quicksort(array, left, pivotNewIndex - 1)
            // quicksort(array, pivotNewIndex + 1, right)
            quicksort(arr, left, pivotNewIndex - 1);
            quicksort(arr, pivotNewIndex + 1, right);
        }
    }

    static int DATA_SIZE = 3000000;
    static int MAX_EXTRA_THREADS = 7;
    static int MIN_PARALLEL = 500;

    // To get to reducePermits
    @SuppressWarnings("serial")
    class Semaphore2 extends Semaphore {
        public Semaphore2(int permits, boolean fair) {
            super(permits, fair);
        }
        public void removePermit() {
            super.reducePermits(1);
        }
    }

    class QuickSortAction implements Runnable {
        final int[] arr;
        final int left;
        final int right;
        final SortState ss;

        public QuickSortAction (int[] arr, int left, int right, SortState ss) {
            this.arr = arr;
            this.left = left;
            this.right = right;
            this.ss = ss;
        }

        public void run () {
            try {
                //System.out.println(">>[" + left + "|" + right + "]");
                pquicksort(arr, left, right, ss);
                //System.out.println("<<[" + left + "|" + right + "]");
                ss.limit.release();
                ss.countdown.release();
            } catch (Exception ex) {
                // I got nothing for this
                throw new RuntimeException(ex); 
            }
        }

    }

    class SortState {
        final public ThreadPoolExecutor pool = new ThreadPoolExecutor(
            MAX_EXTRA_THREADS,
            MAX_EXTRA_THREADS,
            Long.MAX_VALUE,
            TimeUnit.NANOSECONDS,
            new LinkedBlockingQueue<Runnable>());
        // actual limit: executor may actually still have "active" things to process
        final public Semaphore limit = new Semaphore(MAX_EXTRA_THREADS, false); 
        final public Semaphore2 countdown = new Semaphore2(1, false); 
    }

    void pquicksort (int[] arr) throws Exception {
        SortState ss = new SortState();
        pquicksort(arr, 0, arr.length - 1, ss);
        ss.countdown.acquire();
    }

    // pquicksort
    // threads "fork" if available.
    void pquicksort (int[] arr, int left, int right, SortState ss) throws ExecutionException, InterruptedException {
        if (right > left) {
            // memory barrier -- pquicksort is called from different threads
            // and those threads may be created because they are in an executor
            synchronized (arr) {}

            int pivotIndex = left + (right - left) / 2;
            int pivotNewIndex = partition(arr, left, right, pivotIndex);

            {
                int newRight = pivotNewIndex - 1;
                if (newRight - left > MIN_PARALLEL) {
                    if (ss.limit.tryAcquire()) {
                        ss.countdown.removePermit();
                        ss.pool.submit(new QuickSortAction(arr, left, newRight, ss));
                    } else {
                        pquicksort(arr, left, newRight, ss);
                    }
                } else {
                    quicksort(arr, left, newRight);
                }
            }

            {
                int newLeft = pivotNewIndex + 1;
                if (right - newLeft > MIN_PARALLEL) {
                    if (ss.limit.tryAcquire()) {
                        ss.countdown.removePermit();
                        ss.pool.submit(new QuickSortAction(arr, newLeft, right, ss));
                    } else {
                        pquicksort(arr, newLeft, right, ss);
                    }
                } else {
                    quicksort(arr, newLeft, right);
                }
            }

        }        
    }

    long qsort_call (int[] origData) throws Exception {
        int[] data = Arrays.copyOf(origData, origData.length);
        long start = System.nanoTime();
        quicksort(data, 0, data.length - 1);
        long duration = System.nanoTime() - start;
        if (!check(data)) {
            throw new Exception("qsort not sorted!");
        }
        return duration;
    }

    long pqsort_call (int[] origData) throws Exception {
        int[] data = Arrays.copyOf(origData, origData.length);
        long start = System.nanoTime();
        pquicksort(data);
        long duration = System.nanoTime() - start;
        if (!check(data)) {            
            throw new Exception("pqsort not sorted!");
        }
        return duration;
    }

    public Main () throws Exception {
        long qsort_duration = 0;
        long pqsort_duration = 0;
        int ITERATIONS = 10;
        for (int i = 0; i < ITERATIONS; i++) {
            System.out.println("Iteration# " + i);
            int[] data = genData(DATA_SIZE);
            if ((i & 1) == 0) {
                qsort_duration += qsort_call(data);
                pqsort_duration += pqsort_call(data);
            } else {
                pqsort_duration += pqsort_call(data);
                qsort_duration += qsort_call(data);
            }
        }
        System.out.println("====");
        System.out.println("qsort average seconds: " + (float)qsort_duration / (ITERATIONS * 1E9));
        System.out.println("pqsort average seconds: " + (float)pqsort_duration / (ITERATIONS * 1E9));
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}