if (scanner.hasNextInt()) {
    // It's an integer
    int choice = scanner.nextInt();
    switch (choice) {
        ...
    }
}
else {
    // A scanner input is always parseable as a string
    String choice = scanner.nextLine();
    if (Objects.equals(choice, "x")) {
        // Stop, exit, return, terminate and abort
    }
    else {
        // What happens if the user entered an invalid string?
        // You decide!
    }
}