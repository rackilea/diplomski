public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int card = 0;
    int cardNext;

    String userResponse;
    String userPlayAgain;
    boolean userGuessedRight = true;

    do {
        do {
            Random randomNumbers = new Random();
            card = randomNumbers.nextInt(13 - 1 + 1) + 1;
            System.out.println("Card is " + card);

            System.out.print("Higher or Lower?");
            cardNext = randomNumbers.nextInt(13) + 1;
            userResponse = scan.next();
            userGuessedRight = (userResponse.equalsIgnoreCase("H") && cardNext >= card)
                    || (userResponse.equalsIgnoreCase("L") && cardNext <= card);

            if (userGuessedRight) {
                System.out.println("Card is " + cardNext);
                System.out.print("Higher or Lower?");
                userResponse = scan.next();
            } else {
                break;
            }
        } while (userResponse.equalsIgnoreCase("H") && cardNext < card || userResponse.equalsIgnoreCase("L") && cardNext > card);
        System.out.println("Card is " + cardNext);
        System.out.println("Card is higher/lower you lose – play again? Y/N : ");
        userPlayAgain = scan.next();
    } while (userPlayAgain.equalsIgnoreCase("Y"));

    do {
        if (userPlayAgain.equalsIgnoreCase("N"))

        {
            System.out.print("Thank You.");
            break;
        }

    } while (!userPlayAgain.equalsIgnoreCase("Y"));

    scan.close();
}