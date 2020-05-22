public static int[] maxArr(int[] a, int[] b) {
    int[] newArray = new int[Math.max(a.length, b.length)];
    int min = Math.min(a.length, b.length);
    for (int i = 0; i < min; i++) {
        if (a[i] >= b[i]) {
            newArray[i] = a[i];
        } else {
            newArray[i] = b[i];
        }
    }

    if (a.length > b.length) {
        System.arraycopy(a, min, newArray, min, a.length - min);
    } else {
        System.arraycopy(b, min, newArray, min, b.length - min);
    }

    return newArray;
}