public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Please enter an integer ");
    int lines = scan.nextInt();

    for (int counter = 1; counter <= lines; counter++) {

        if (counter % 2 != 0) {
            for (int i = 0; i < lines - (counter / 2) - 3; i++) {
                System.out.print(" ");
            }
            for (int count2 = 1; count2 <= counter; count2++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    for (int counter = lines - 1; counter >= 1; counter--) {

        if (counter % 2 != 0) {
            for (int i = 0; i < lines - (counter / 2) - 3; i++) {
                System.out.print(" ");
            }
            for (int count2 = 1; count2 <= counter; count2++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}