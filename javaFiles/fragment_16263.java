System.out.println("The first "+m+ " multiples of "+n+" are: ");

for (int i = 1; i <= m; ++i) {
    if (i > 1) {
        System.out.print(", ");
        if (i==m) {
            System.out.print("and ");
        }
    }
    System.out.print(i*n);
}
System.out.println(".");