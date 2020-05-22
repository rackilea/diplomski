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
    } catch(Exception e) {
         System.out.println(e);
    }
 }