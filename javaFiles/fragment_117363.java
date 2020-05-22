public int compare(int[] a, int[] b) {

    if (a.length == b.length) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {

            } else {
                return a[i] - b[i];
            }
        }
        return 0;

    } else {
        return a.length < b.length ? -1 : 1;
    }                       
}