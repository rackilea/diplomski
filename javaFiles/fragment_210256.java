public int min(int[] a) {
    int min = 0;
    for (int i = 1; i < a.length, i++) {
        if (a[i] <  a[min]) {
            min = i;
        }
    }
    return i;    //returning i which only exist in for-loop scope. Wrong!
}