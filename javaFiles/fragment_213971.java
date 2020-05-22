import java.util.Arrays;

public class Temp {
    public static class SmartQuickSortPivot {
        public int left;
        public int right;
    }

    static int[] values = {2,5,1,66,89,44,32,51,8,6};   // values to be sorted


    /**
     * split4SmartQuickSort splits the array (from first to last) into two subarrays, left and right, using the
     * provided splitVal. It needs to calculate on the fly the average of all the elements of the left subarray
     * and average of all elements of the right subarray, and store the two averages in the @pivot object.
     * The following implementation is only copy of the code from
     * the split function (from line 247) and you should enhance the function to implement what we need to calculate the averages
     * as the pivot for the left and right subarray.
     *
     * Please be noted that splitVal may not even exist in the array since we choose the average.
     * But this should not impact the correctness algorithm of splitting and sorting.
     * @param first
     * @param last
     * @param splitVal
     * @param leftRightAverages
     * @return
     */
    static SmartQuickSortPivot split4SmartQuickSort(int first, int last, int splitVal, SmartQuickSortPivot leftRightAverages)
    {
        int i = first,j = last;
        int sumLeft = 0;
        int sumRight = 0;
        while (i < j) {
            while (values[i] < splitVal){
                sumLeft += values[i];
                i++;
            }

            while (values[j] > splitVal){
                sumRight += values[j];
                j--;
            }

            if (i < j) {
                swap(i, j);
            }
        }
        leftRightAverages.left = (i - first == 0) ? values[first] : sumLeft / (i - first);
        leftRightAverages.right = (last - j == 0) ? values[last] : sumRight / (last - j);

        SmartQuickSortPivot smartQuickSortPivot = new SmartQuickSortPivot();
        smartQuickSortPivot.left = i;
        smartQuickSortPivot.right = j;
        return smartQuickSortPivot;
    }

    private static void swap(int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    /**
     * Smart quick sort allows the use of a better splitting value (the pivot value) when to split the array
     * into two. In this algorithm, we will use the average of the array (subarray) of all elements as the pivot.
     *
     * Each call to split (split4SmartQuickSort method), the splitValue will be passed and also the split4SmartQuickSort
     * will return the averages of left subarray and right subarray. The two averages, each will be used for the
     * following calls to smartQuickSort.
     *
     * @param first the first element
     * @param last the last element
     * @param splitVal the pivot value for splitting the array
     */
    static void smartQuickSort(int first, int last, int splitVal)
    {
        if (first < last)
        {
            SmartQuickSortPivot splitPoint;
            SmartQuickSortPivot leftRightAverages = new SmartQuickSortPivot();

            splitPoint = split4SmartQuickSort(first, last, splitVal, leftRightAverages);
            if (first < splitPoint.left)
            {
                smartQuickSort(first, splitPoint.left - 1, leftRightAverages.left);
            }
            if (last > splitPoint.right)
            {
                smartQuickSort(splitPoint.right + 1, last, leftRightAverages.right);
            }
        }
    }

    public static void main(String[] args)
    {

        /** you can either compute the average first as the first pivot or simplify choose the first one as the pivot */
        smartQuickSort(0, values.length - 1, values[5]);
        System.out.println(Arrays.toString(values));
    }
}