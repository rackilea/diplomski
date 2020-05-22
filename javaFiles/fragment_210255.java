public int min(int[] a) {
    int min = 0;
    for (int i = 1; i < a.length, i++) {
        if (a[i] <  a[min]) {
            min = i;
        }
    }
    return a[i];    //returning value. Wrong!
                    //you are searching for the index, not value isnt' it?
}