for (int i = 0; i < input; i++) {
    for (int j = 0; j < input; j++) {
        if (j == input / 2 || i == input / 2 || i + j == input - 1) {
            System.out.print("* ");
        } else {
            System.out.print("  ");
        }
    }
    System.out.println();
}