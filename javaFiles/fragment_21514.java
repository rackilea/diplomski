import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    // experiment variables:
    public static final int NUM_ELEMENTS = 150;
    public static final int NUM_WARMUP_ROUNDS = 100000;
    public static final int NUM_EXPERIMENTS = 200;
    // aux variables:
    private static Random rand = new Random();
    private static List<Integer> list;

    // selection method implementation:
    private static void swap(int[] arr, int idx1, int idx2) { 
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    private static int partition(int[] arr, int left, int right) { 
        int pivotIdx = left + rand.nextInt(right-left);
        swap(arr, pivotIdx, right - 1);
        right = pivotIdx = right-1;
        int pivot = arr[pivotIdx];
        while (left < right) { 
            while (arr[left] < pivot && left < right) left++;
            while (arr[right] >= pivot && right > left) right--;
            if (left >= right) break;
            swap(arr, left, right);
        }
        // now, left is the first element bigger than pivot.
        swap(arr, pivotIdx, left);
        return left;
    }

    public static int quickSelect(int[] arr, int n) { 
        return quickSelect(arr, n, 0, arr.length);
    }

    private static int quickSelect(int[] arr, int n, int l, int r) { 
        int p = partition(arr, l, r);
        if (n == p) return arr[p];
        if (n < p) return quickSelect(arr, n, l, p + 1);
        return quickSelect(arr, n, p, r);
    }

    // we are assuming arr.length % 3 == 0 for simplicty;
    public static int[][] getThreeBucketsSelection(int[] arr) { 
        int[] first_bucket = new int[arr.length / 3];
        int i1 = 0;
        int[] second_bucket = new int[arr.length / 3];
        int i2 = 0;
        int[] third_bucket = new int[arr.length / 3];
        int i3 = 0;
        int p1 = quickSelect(arr, arr.length / 3);
        int p2= quickSelect(arr, (arr.length / 3) * 2);
        for (int x : arr) { 
            if (x < p1) first_bucket[i1++] = x;
            else if (x < p2) second_bucket[i2++] = x;
            else third_bucket[i3++] = x;
        }
        return new int[][] {first_bucket, second_bucket, third_bucket};
    }

    // sorting implementation:
    public static int[][] getThreeBucketsSort(int[] arr) { 
        Arrays.sort(arr);
        int[] first_bucket = new int[arr.length / 3];
        int i1 = 0;
        int[] second_bucket = new int[arr.length / 3];
        int i2 = 0;
        int[] third_bucket = new int[arr.length / 3];
        int i3 = 0;
        int i = 0;
        while (i < arr.length / 3) first_bucket[i1++] = arr[i++];
        while (i < 2 * arr.length / 3) second_bucket[i2++] = arr[i++];
        while (i < arr.length) third_bucket[i3++] = arr[i++];
        return new int[][] {first_bucket, second_bucket, third_bucket};     
    }

    // experiment methods:
    public static int[] createRandomPermutation() { 
        Collections.shuffle(list);
        int[] arr = new int[list.size()];
        int i = 0;
        for (int x : list) arr[i++] = x;
        return arr;
    }

    public static List<Integer> populateOriginalList(int numElements) { 
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numElements; i++)  result.add(i);
        return result;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        list = populateOriginalList(NUM_ELEMENTS);
        long sumWarmUpTime = 0; 
        for (int i = 0; i < NUM_WARMUP_ROUNDS; i++) { 
            int[] arr1 = createRandomPermutation();
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            long warmupIter = System.nanoTime();
            int[][] buckets1 = getThreeBucketsSelection(arr1);
            int[][] buckets2 = getThreeBucketsSort(arr2);
            sumWarmUpTime += System.nanoTime() - warmupIter;
        }

        System.out.println("Done warm up. Took: " + sumWarmUpTime + " nanos");
        List<Long> selectionTimes = new ArrayList<>();
        List<Long> sortTimes = new ArrayList<>();

        long quickSelectTotal = 0;
        long sortTotal = 0;
        for (int i = 0 ; i < NUM_EXPERIMENTS/2; i++) { 
            int[] arr1 = createRandomPermutation();
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            // selection:
            long quickSelectTime = System.nanoTime();
            int[][] buckets1 = getThreeBucketsSelection(arr1);
            quickSelectTime = (System.nanoTime() - quickSelectTime);
            quickSelectTotal += quickSelectTime;
            selectionTimes.add(quickSelectTime);
            // sort:
            long sortTime = System.nanoTime();
            int[][] buckets2 = getThreeBucketsSort(arr2);           
            sortTime = (System.nanoTime() - sortTime);
            sortTotal += sortTime;
            sortTimes.add(sortTime);
        }

        // and flip their order, to make sure no bias:
        for (int i = 0 ; i < NUM_EXPERIMENTS/2; i++) { 
            int[] arr1 = createRandomPermutation();
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            // sort:
            long sortTime = System.nanoTime();
            int[][] buckets1 = getThreeBucketsSort(arr1);           
            sortTime = (System.nanoTime() - sortTime);
            sortTotal += sortTime;
            sortTimes.add(sortTime);

            // selection:
            long quickSelectTime = System.nanoTime();
            int[][] buckets2 = getThreeBucketsSelection(arr2);
            quickSelectTime = (System.nanoTime() - quickSelectTime);
            quickSelectTotal += quickSelectTime;
            selectionTimes.add(quickSelectTime);            
        }       

        System.out.println("values for wilcoxon test");
        System.out.println("sort times: "  + sortTimes);
        System.out.println("selection times: "  + selectionTimes);

        System.out.println("Bottom lime results: ");
        System.out.println("sort: " + sortTotal);
        System.out.println("selection: " + quickSelectTotal);
    }
}/* package whatever; // don't place package name! */