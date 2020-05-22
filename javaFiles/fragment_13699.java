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
    static int MAX_THREADS = 4;
    static int MIN_PARALLEL = 1000;

    // NOTE THAT THE THREAD POOL EXECUTER USES A LINKEDBLOCKINGQUEUE
    // That is, because it's possible to OVER SUBMIT with this code,
    // even with the semaphores!
    ThreadPoolExecutor tp = new ThreadPoolExecutor(
            MAX_THREADS,
            MAX_THREADS,
            Long.MAX_VALUE,
            TimeUnit.NANOSECONDS,
            new LinkedBlockingQueue<Runnable>());
    // if there are no semaphore available then then we just continue
    // processing from the same thread and "deal with it"
    Semaphore sem = new Semaphore(MAX_THREADS, false); 

    class QuickSortAction implements Runnable {
        int[] arr;
        int left;
        int right;

        public QuickSortAction (int[] arr, int left, int right) {
            this.arr = arr;
            this.left = left;
            this.right = right;
        }

        public void run () {
            try {
                //System.out.println(">>[" + left + "|" + right + "]");
                pquicksort(arr, left, right);
                //System.out.println("<<[" + left + "|" + right + "]");
            } catch (Exception ex) {
                // I got nothing for this
                throw new RuntimeException(ex); 
            }
        }

    }

    // pquicksort
    // threads will [hopefully] fan-out "breadth-wise"
    // this is because it's likely that the 2nd executer (if needed)
    // will be submitted prior to the 1st running and starting its own executors
    // of course this behavior is not terribly well-define
    void pquicksort (int[] arr, int left, int right) throws ExecutionException, InterruptedException {
        if (right > left) {
            // memory barrier -- pquicksort is called from different threads
            synchronized (arr) {}

            int pivotIndex = left + (right - left) / 2;
            int pivotNewIndex = partition(arr, left, right, pivotIndex);

            Future<?> f1 = null;
            Future<?> f2 = null;

            if ((pivotNewIndex - 1) - left > MIN_PARALLEL) {
                if (sem.tryAcquire()) {
                    f1 = tp.submit(new QuickSortAction(arr, left, pivotNewIndex - 1));
                } else {
                    pquicksort(arr, left, pivotNewIndex - 1);
                }
            } else {
                quicksort(arr, left, pivotNewIndex - 1);
            }
            if (right - (pivotNewIndex + 1) > MIN_PARALLEL) {
                if (sem.tryAcquire()) {
                    f2 = tp.submit(new QuickSortAction(arr, pivotNewIndex + 1, right));
                } else {
                    pquicksort(arr, pivotNewIndex + 1, right);
                }
            } else {
                quicksort(arr, pivotNewIndex + 1, right);
            }

            // join back up
            if (f1 != null) {
                f1.get();
                sem.release();
            }
            if (f2 != null) {
                f2.get();
                sem.release();
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
        pquicksort(data, 0, data.length - 1);
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