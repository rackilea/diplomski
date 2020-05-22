public static void main(String[] args) {
    int[] arr = new int[10];
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 3;
    arr[4] = 4;
    arr[5] = 5;

    list(arr, 2, 5);
}

private static void list(int[] arr, int a, int b) {
    if (a >= 0 && b <= arr.length) {
        for (int i = a; i < b; i++) {
            System.out.println(arr[i]);
        }
    } else {
        System.out.println("unknown");
    }
}