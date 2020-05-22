public static void main(String a[]) {
    System.out.println("Welcome");
    Scanner myinput = new Scanner(System.in);
    boolean quit = false;
    while (!quit) {
        System.out
                .println("Make your choise. \n 1.Check a card number \n 2.Quit.");
        int choise = myinput.nextInt();
        switch (choise) {
        case 1:
            System.out.println("Enter your credit card number: ");
            break;
        case 2:
            System.out.println("Are you sure?");
            String answer = myinput.next();

            if (answer.equals("yes")) {
                System.out.println("Byee :)");
                quit= true;
            }
            break;
        default:
            System.out.println("Idiot!");
            break;
        }
    }