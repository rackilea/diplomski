public static void main(String []args) {
        int temp;
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int j = 1; j < arr.length; j += 2) {
                temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
        }
        System.out.print(Arrays.toString(arr));
}