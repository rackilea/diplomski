public static void printEvenTable(int n) {
    int i;
    int j;
    int k = 0;

    for (i = 1; i <= n; i++) {
         k = 0;
         for (j = 0; j < i; j++)
            System.out.print(" " + (k += 2));


        System.out.println(" ");
    }
}