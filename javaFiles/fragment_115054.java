public boolean haveThree(int[] a) {
    if (a == null || a.length < 3) {
        return false;
    }
    int count = 0;
    for (int i = 0; i < a.length; i++) {
        if (a[i] == 3) {
            if (i > 0 && a[i - 1] == 3) {
                return false;
            }
            count++;
        }
    }
    return count == 3;
}