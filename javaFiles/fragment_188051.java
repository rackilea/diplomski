outer: for (int i = 999; i >= 100; i--) {
    for (int j = 999; j >= 100; j--) {
        long product = j * i;
        if (reverse(product)) {
            System.out.printf("%d * %d = %d%n", i, j, product);
            break outer;
        }
    }
}