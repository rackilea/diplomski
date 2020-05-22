int n = 3; // You can use any number here in your case it is 3

for (int line = 1; line <= n; line++) {
    for (int i = - 1 * line + n; i >= 1; i--) {
        System.out.print(" ");
    }
    //-------------------------------------------
    for (int j = line; j >= 1; j--) {
        System.out.print(j);
    }
    //-------------------------------------------
    System.out.println();
}