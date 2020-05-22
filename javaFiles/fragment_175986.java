private static int getValidInt(Scanner s) {
    System.out.println("Enter the number you want to see the factorial of (0-12)");

    int input = getInt(s);
    while (input < 0 || input > 12) {
        System.out.println("Enter an integer between 0 and 12.");
        s.next();
        input = getInt(s);
    }
    return input;
}

private static int getInt(Scanner s) {
    while (!s.hasNextInt()) {
        System.out.println("Enter a number");
        s.next();
    }

    return s.nextInt();
}