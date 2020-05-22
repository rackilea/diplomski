public static void printPowersOf2(int num) {
    for (int i = 0; i < num; i++) {
        System.out.print("%d ", Math.pow(2, i));
    }
    System.out.println(); // for the line break
}