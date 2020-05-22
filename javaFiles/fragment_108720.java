int n = 12;
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        if (j != 0) {
            System.out.print(" | ");
        }
        System.out.printf("% 4d", (1+i) * (1+j));
    }
    System.out.println();
}