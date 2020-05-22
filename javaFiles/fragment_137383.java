do {

        do {
            try {
                System.out.println("Guess a number between 1-100: ");
                userGuess = Integer.parseInt(sc.nextLine());
                if (userGuess < 1 || userGuess > 100) {
                    System.err
                            .println("Error : your Guess must be between 1-100");
                }
            } catch (Exception e) {
                System.err
                        .println("Error : your Guess must be between 1-100");
            }
        } while (userGuess < 1 || userGuess > 100);

        System.out.println(" " + userGuess);

        if (userGuess > compGuess) {
            System.out.println("Your Guess is: " + userGuess
                    + "and the random number: " + compGuess);
            System.out.println("Sorry, you need to go LOWER  :");

        }
        if (userGuess < compGuess) {
            System.out.println("Your Guess is: " + userGuess
                    + "and the random number: " + compGuess);
            System.out.println("Sorry, you need to go HIGHER  :");
            System.out.println("if 1");
        }
        numAttempts++;

        if (userGuess == compGuess) {
            System.out.println("Lucky Number was : " + compGuess
                    + "your  guess was : " + userGuess);
            System.out.println("Congratulations you won " + 10 + "$");
            // player.setGamesWon(1);
            // player.setTotalWinnings(10);

        }

    } while (userGuess != compGuess & numAttempts < 3);

    if (userGuess != compGuess && (userGuess <= (compGuess + 5))
            || (userGuess >= (compGuess - 5))) {
        System.out.println("Lucky Number was : " + compGuess
                + " your FINAL guess was : " + userGuess);
        // System.out.println("Congratulations you won " + cnum + "$");
        // player.setTotalWinnings(5);

    } else if (userGuess != compGuess) {
        System.out.println("Lucky Number was : " + compGuess
                + "your  guess was : " + userGuess);
        System.out.println("Sorry better Luck Next time");
        // player.setGamesLost(1);
        // player.setTotalWinnings(-1);

    }

}