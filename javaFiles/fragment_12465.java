do {
    while (!keyboard.hasNextInt()) {
        System.out.println("Please enter only numbers.");
        keyboard.next(); // Skip the wrong token
    }
    // Now that the input is valid, read the value:
    guess = keyboard.nextInt();
    // Put the rest of your logic here
    ...
} while (guess != secretNumber);