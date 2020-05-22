public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] title = new String[100], author = new String[100], publisher = new String[100], ISBN = new String[100],
            endinput = new String[100];
    // boolean Stop = false;
    boolean Yes = true;
    double[] price = new double[100];

    while (Yes) {
        System.out.println("Welcome To Kieran's Bookstore");
        System.out.println("Input The Title:");
        title[0] = scan.next();
        System.out.println("Input The Author:");
        author[0] = scan.next();
        System.out.println("Input The Price Of The Book:");
        scan.next();
        System.out.println("Input The Publisher:");
        publisher[0] = scan.next();
        System.out.println("Input The ISBN:");
        ISBN[0] = scan.next();
        System.out.println("Would you like to continue?(Yes/Stop)");
        String ans = scan.next();
        if (ans.equals("endinput") || (ans.equals("Stop"))) {
            Yes = false;
            System.exit(0);
        }
    }
}