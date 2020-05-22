while (guess != number) {
    System.out.print("Enter your guess: ");
    guess = scanner.nextInt();
    try {
        if (guess < number) {
            throw new TooLowException();
        } else if (guess > number) {
            throw new TooHighException();
        } else {
            throw new CorrectException();
        }
    } // end the try block
 }