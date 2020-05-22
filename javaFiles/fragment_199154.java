for (int x = 1; x <= i; x++) {
    System.out.printf("%4d", x);
    for (int y = 2; y <= i; y++) {
        System.out.printf("%4d", x * y);
    }
    System.out.println();
}