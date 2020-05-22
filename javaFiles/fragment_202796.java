public class MergeSort {

    private static int [] tempArray;

    public void mSort(int [] A, int low, int high) {
        if (high > low) {
            int mid = low + (high - low) / 2;
            mSort(A, low, mid);
            mSort(A, mid + 1, high);
            Merge(A, low, mid + 1, high);
        }
    }

    public void Merge(int [] A, int low, int mid, int high) {
        int indexlow = low;
        int indexhigh = mid;
        int index = low;
        while(indexlow < mid || indexhigh <= high) {
            if(indexlow >= mid) {
                tempArray[index] = A[indexhigh];
                indexhigh++;
            } else if(indexhigh > high) {
                tempArray[index] = A[indexlow];
                indexlow++;
            } else if(A[indexlow] <= A[indexhigh]) {
                tempArray[index] = A[indexlow];
                indexlow++;
            } else {
                tempArray[index] = A[indexhigh];
                indexhigh++;
            }
            index++;
        }
        for(int i = low; i <= high; i++) {
            A[i] = tempArray[i];
        }
    }

    public static void main(String[] args) {
        int [] inputArray = {4, 10, 1, 5, 3, 8, 7, 6};
        tempArray = new int[inputArray.length];
        MergeSort myMergeSort = new MergeSort();
        myMergeSort.mSort(inputArray, 0, inputArray.length-1);
        for(int i : inputArray) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}