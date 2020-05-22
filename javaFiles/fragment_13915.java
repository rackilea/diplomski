class Quicksort
{
    void sort(int[] arr)
    {
        myQuicksort(arr, 0, arr.length - 1);
    }

    private void myQuicksort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivotIndex = (l + r) / 2;
        swap (arr, r, pivotIndex);

        int pivotValue = arr[r];
        int swapIndex = 0;
        int currentIndex = 0;

        while (currentIndex != r) {
            if (arr[currentIndex] < pivotValue) {
                swap(arr, currentIndex, swapIndex);
                swapIndex++;
            }

            currentIndex++;
        }

        swap(arr, r, swapIndex);

        myQuicksort(arr, l, swapIndex - 1);
        myQuicksort(arr, swapIndex + 1, r);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class Main{
    public static void main(String[] args) {
        Quicksort quicksort = new Quicksort();

        int[] arr = {3, 7, 1, 0, 4};
        quicksort.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}