public static void diamond() {
    int i = 0;
    int j = 0;
    int k = 0;
    int height = 0;

    Scanner in = new Scanner(System.in);
    System.out.println("How tall do you want the diamond to be: ");
    height = in.nextInt();

    for (k = 1; k <= (height + 1) / 2; k++) {
        for (i = 0; i < height - k; i++) {
            System.out.print(" ");
        }
        for (j = 0; j < k; j++) {
            if (j == 0 || j == (k - 1)) {
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println("");
    }

    for (k = ((height + 1) / 2); k < height; k++) {
        for (i = 1; i < k; i++) {
            System.out.print(" ");
        }
        for (j = 0; j < height - k; j++) {
            if (j == 0 || j == (height - k - 1)) {
                System.out.print(" *");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println("");
    }
}