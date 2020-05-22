public static void fill(Integer[] newarr, Integer[] arr, int index) {
    if (arr[index] != null) {
        newarr[index] = arr[index];
        return;
    }

    Integer a = null, b = null;

    int i = index;
    while (i < arr.length - 1 && (a = arr[++i]) == null);

    i = index;
    while (i > 1 && (b = arr[--i]) == null);

    newarr[index] = (a == null) ? b : (b == null) ? a : (a + b) / 2;
}