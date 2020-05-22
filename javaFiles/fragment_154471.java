public static int arrayMin(int[] arr) {
    int i = 0;
    int min = Integer.MAX_VALUE;
    if (arr == null) {
        return 0; // What if 0 is the minimum value? What do you want to do in this case?
    } else {
        while (i < arr.length) {
            if (arr[i] < min) {
              min = arr[i];
            }
            i++;
        }
    }
    return min;
}