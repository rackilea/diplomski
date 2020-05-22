public static void main(String args[]) {
    String a[] = new String[] {
        "Sam", "Claudia", "Josh", "Toby", "Donna"
    };
    int b[] = new int[] {
        1, 2, 3, 4, 5
    };
    for (int n = 0; n < 5; n++) {
        System.out.print(a[n] + "...");
        System.out.println(b[n]);
    }
    System.out.println(" ");
    //java.util.Arrays.sort(a);
    /* Bubble Sort */
    for (int n = 0; n < 5; n++) {
        for (int m = 0; m < 4 - n; m++) {
            if ((a[m].compareTo(a[m + 1])) > 0) {
                String swapString = a[m];
                a[m] = a[m + 1];
                a[m + 1] = swapString;
                int swapInt = b[m];
                b[m] = b[m + 1];
                b[m + 1] = swapInt;
            }
        }
    }
    for (int n = 0; n < 5; n++) {
        System.out.print(a[n] + "...");
        System.out.println(b[n]);
    }
}