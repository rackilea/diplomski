public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = input.nextInt();
    // Higher half of the K
    for (int row = 0; row < (n-1)/2; row++) {
        for (int column = 0; column < n-1; column++) {
            if (column == 0 || column == n-2-row ) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    //Middle line
    System.out.println("* *");
    // Lower half of the K
    for (int row = (n-1)/2-1; row >= 0; row--) {
        for (int column = 0; column < n-1; column++) {
            if (column == 0 || column == n-2-row ) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}