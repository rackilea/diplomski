private static int getBet(Scanner inScanner, int moneyPot) {

    int result;
    System.out.println("Enter an amount to bet (1-100) (0 to quit): ");
    do {
        result = inScanner.nextInt();
        if (result == 0) {
            System.out.println("Good Bye");
            return result;
        } else if (result < 0 && result > 100) {
            System.out.println("Please enter an amount between (1-100) (0 to quit)");
        } else if (result > moneyPot) {
            System.out.println("Please enter an amount less than your moneyPot between (1-100)  (0 to quit)");
        } else {
            return result;
        }
    } while (true);
}