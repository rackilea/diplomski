int rjbnum1 = 5;

for (int i = rjbnum1; i > 0; i--) {
    for (int j = 1; j <= rjbnum1; j++) {
        if (j >= i) {
            System.out.print("\t" + i);
        } else {
            System.out.print("\t");
        }
    }
    System.out.println();
}