public static int[] removeDuplicates(int a[]) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n;) {
            if (a[j] == a[i]) {
                for (int k = j; k < n-1; k++)
                    a[k] = a[k + 1];
                n--;
            } else
                j++;
        }
    }

     int[] newArray = new int[n];
     System.arraycopy(a, 0, newArray, 0, n);

     return newArray;
}