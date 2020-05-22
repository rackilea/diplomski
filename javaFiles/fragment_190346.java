// Creates a "scanner" for the input
        Scanner readInput = new Scanner(System.in);

        // Print out random integer and open close message.
        System.out.println("Printing Random Numbers between 1-200: ");
        try {
            int guess = readInput.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("You didn't enter a number.");
        }