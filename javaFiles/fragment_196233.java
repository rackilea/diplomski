boolean invalidInput;
do {
    invalidInput = false;
    try {
        System.out.println("Enter the book quantity");
        int q = s.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Please enter a valid integer.");  // this is more polite
        invalidInput = true;  // This is what will get the program to loop back
        s.nextLine();
    }
} while (invalidInput);