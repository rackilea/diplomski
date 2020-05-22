do {
        try {
            System.out.println("Guess a number between 1-100: ");
            userGuess = Integer.parseInt(scanner.nextLine());
            if (userGuess < 1 || userGuess > 100) {
                System.err.println("Error : your Guess must be between 1-100");
            }
        } catch (Exception e) {
            System.err.println("Error : your Guess must be between 1-100");
        } 
    } while(userGuess < 1 && userGuess > 100);//incorrect

//correct condition -> while(userGuess < 1 || userGuess > 100);