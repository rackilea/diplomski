int n = 3;
for (int i = n; i >= 1; i--) {
    System.out.println();
    for (int j = n - 1; j > -n; j--) {
        int k = n - Math.abs(j);
        System.out.print(k);
    }
}
System.out.println();