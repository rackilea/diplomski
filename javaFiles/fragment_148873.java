while (i < 10) {
    try {
        System.out.print("Please enter your number\n");
        numberlist[i] = input.nextInt();
        System.out.print("Would you like to enter another number? (y/n)\n");
        yn = input.next();
        i++;
        if (i == 10) {
            System.out.println("You reached the maximum amount of numbers\n");
            break;
        }

        if (yn.equals("n"))
            break;
        else if (!yn.equals("y"))
            makeUserUnderstand(input,
                    "Please only enter a 'y' for yes or 'n' for no next time.");

    } catch (InputMismatchException e) {
        makeUserUnderstand(input,
                "Please enter the correct number (integers only) next time.");
    }
}