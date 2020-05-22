public static int thirdLargest(int[] arr) {

    int max1 = findMax(arr);
    int p[] = remove(arr, max1);
    int max2 = findMax(p);
    int q[] = remove(p, max2);
    int max3 = findMax(q);
    return max3;
}

static int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] >= max) {
            max = arr[i];

        }
    }
    return max;
}

static int[] remove(int[] arr, int max) {
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == max) {
            index = i;
            break;
        }
    }

    int p[] = new int[arr.length - 1];
    for (int m = 0, n = 0; m < arr.length; m++) {

        if (index != m) {
            p[n] = arr[m];
            n++;
        }
    }
    return p;

}