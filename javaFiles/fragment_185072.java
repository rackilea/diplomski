for (int i = 1; i <= rows; i++) {
    System.out.println("");
    System.out.printf("%d |", i);

    for (int j = 1; j <= columns; j++) {
        System.out.printf("%5d", i * j);
    }
}