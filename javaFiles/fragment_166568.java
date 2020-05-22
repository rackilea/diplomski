do {
    try {
        String input = scan.nextLine();
        int choose = Integer.parseInt(input);
        // ...
    catch (InputMismatchException | NumberFormatException e) {
        System.out.println("Error in the data you have entered please try again");
    }
} while (true);