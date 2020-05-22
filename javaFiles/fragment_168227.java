int n = 3;
for (int i = n; i >= 1; i--) {
    System.out.println();
    for (int j = n - 1; j > -n; j--) {
        int k = n - Math.abs(j);
        if (k <= i) {
            System.out.print(k);
        } else {
            System.out.print(" ");
        }
    }
}
System.out.println();