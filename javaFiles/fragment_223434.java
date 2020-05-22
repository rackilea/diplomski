do {

    System.out.println("Enter your number:");
    double originalNumber = scan.nextDouble();

    System.out.println("Calculating sum...");
    double modifyingNumber = (int) (Math.random() * ((100 - 0.5 + 10) + 3));
    double result = (originalNumber * modifyingNumber + 10d);

    if (result % 2 == 0) {

        System.out.println("Even- " + result);
    } else {

        System.out.println("Odd- " + result);
    }

    System.out.println("Random number was " + modifyingNumber);

    do {
        System.out.println("Would you like to try again? Y/N");
        answer = scan.next();
    } while(!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));

} while (answer.equalsIgnoreCase("y"));