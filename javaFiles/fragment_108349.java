private static void selectionSort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
        int index = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[index]) {
                index = j;
            }
        }
        if (index != i) {
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
}

public static void main(String[] args) {
    int[] array = { 5, 2, 3, 1, 4, 7, 8, 6, 10, 9 };
    selectionSort(array);
    System.out.println(Arrays.toString(array));
}