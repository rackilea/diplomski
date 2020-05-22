public boolean hasUneven(int[] a) {
    for (int i = 0; i < a.length; i++) {
        if (a[i] % 2 != 0) {
            return true;
        }
    }
    return false;
}