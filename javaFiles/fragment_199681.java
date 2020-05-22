public static void calcPrimes(int max) {
    // each boolean value indicates whether corresponding index
    // position is composite (non-prime)
    boolean[] array = new boolean[max + 1];

    // mark composites as true
    for (int i = 2; i <= (int) Math.sqrt(max); i++) {
        for (int j = i*i; j <= max; j += i) array[j] = true;
    }

    // print indexes with corresponding false values
    for (int k = 2; k <= max; k++) {
        if (!array[k]) System.out.println(k);
    }
}