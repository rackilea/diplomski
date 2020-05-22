private static void sortArr(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int column = 0; column < arr.length - 1; column++) {
            if(arr[column][0] > arr[column + 1][0]) {
                swap(arr, column);
            } else if(arr[column][0] == arr[column + 1][0] && arr[column][1] > arr[column + 1][1]) {
                    swap(arr, column);
            }
        }
    }

}

private static void swap(int[][] arr, int column) {
    int[] temp = arr[column];
    arr[column] = arr[column + 1];
    arr[column + 1] = temp;
}