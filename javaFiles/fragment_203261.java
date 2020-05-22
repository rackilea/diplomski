public static int[] merge(int[] a, int[] b) {

    int[] answer = new int[a.length + b.length]
    int i = a.length - 1, j = b.length - 1, k = answer.length;

    while (k > 0)
        answer[--k] = 
            (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
}