for (int i = 1; i <= row; i++) {
    for (int j = 1; j <= i; j++) {
        if (i == 1) {
            System.out.print(star);
        }
        if (i > 1) {
            System.out.print(star);
            if (i - 1 >= j) {              // <-- change made in this if-block only
                System.out.print(undrscr);
            }
            if (j == i) {
                System.out.print("");
            }
        }
    }
    System.out.println();
}