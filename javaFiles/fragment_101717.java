public static int[] addPos(int[] a, int pos, int num) {
    int[] result = new int[a.length];
    for(int i = 0; i < pos; i++)
        result[i] = a[i];
    result[pos] = num;
    for(int i = pos + 1; i < a.length; i++)
        result[i] = a[i - 1];
    return result;
}