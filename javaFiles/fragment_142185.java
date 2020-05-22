if ("s".equalsIgnoreCase(command)) {
    // Print summary
} else if ("q".equalsIgnoreCase(command)) {
    // Command is "q". Terminate program.
    return;
} else {
    try {
        Integer number = Integer.parseInt(command);
        if(number < 0 || number > 100){
            System.out.println("Please provide a value between 0 and 100");
        } else if(randomInt == number){
            System.out.println("Congratulations! You have guessed correctly." +
                        " Summary below");
            round++;
        } else if(randomInt < number) {
            System.out.println("your guess is TOO HIGH. Guess again or enter Q to Quit");
                 tries++;
        } else if(randomInt > number) {
            System.out.println("your guess is TOO LOW. Guess again or enter Q to Quit");
            tries++;
        }
    } catch (NumberFormatException nfe) {
        // Command is illegal. Display error message.
        System.out.println("Command was not recognized; " +
                       "please enter only a number, S, or q.");
    }
}