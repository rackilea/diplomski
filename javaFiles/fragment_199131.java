public static void main(String[] args) {
    int[] arr = new int[20];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = method1(1, 10);
    }
    method2(arr, arr.length);
}