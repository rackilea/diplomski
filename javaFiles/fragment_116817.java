private void compact(int[] x) {
    int counter = 0;
    for (int j = 0; j < x.length; j++) {
        if (x[j] != 0) {
            x[counter++] = x[j];
        }
    }
    while (counter < x.length) {
        x[counter++] = 0;
    }
    printArray(x);
}