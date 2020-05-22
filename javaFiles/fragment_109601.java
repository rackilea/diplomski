String input = null;
    while (guessResult != -1) {
        System.out.print("Choose a number between 0 and 50: ");

        input = sc.next();
        try
        {
            randomGuess = Integer.parseInt(input);
            checkGuess(randomGuess);
        } catch(NumberFormatException ex)
        {
            System.out.println("Please insert  a number, not  a letter");
        }

    }