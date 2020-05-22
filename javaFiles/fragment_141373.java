if (userInput2.hasNextInt()) {
    int userInt = userInput2.nextInt();
    if (userInt == 1) {
        System.out.println("    You asked to play Rock Paper Scissors");
        System.out.println("    Launching Rock Paper Scissors... \n");
        RockPaperScissors gameRun1 = new RockPaperScissors();
        gameRun1.main(null);
    } else if (userInt == 2) {
        System.out.println("    You asked to run the Tip Calculator");
        System.out.println("    Launching the Tip Calculator... \n");
        TipCalculator gameRun2 = new TipCalculator();
        gameRun2.main(null);
    } else if (userInt == 3) {
        System.out.println("    You asked to run the Number Adding game");
        System.out.println("    Launching the Number Adding game... \n");
        NumberAddingGame gameRun3 = new NumberAddingGame();
        gameRun3.main(null);
    } else if (userInt == 4) {
        System.out.println("    You asked to play GuessingGame");
        System.out.println("    Launching GuessingGame... \n");
        GuessingGame gameRun4 = new GuessingGame();
        gameRun4.main(null);
    } else if (userInt == 5) {
        System.out.println("    You asked for a random game");
        option5();
    } else if (userInt == 6) {
        System.out.println("Thank you for using Conner's Sentinel");
        // figure out how to terminate the program from here
    } else {
        System.out.println("Not a valid input, type 1-6");
        printMenu();
    }
} else {
    userInput2.nextLine(); // <-- consume the non-number
    System.out.println("Not a valid number, type 1-6");
    printMenu();
}