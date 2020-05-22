public int promptForIntValue(String prompt) {
    int value = -1;
    boolean accepted = false;
    do {
        try {
            System.out.print(prompt);
            value = input.nextInt();
            accepted = true;
        } catch (InputMismatchException ex) {
            System.out.println("Input is Wrong");
            input.nextLine();
        }
    } while (!accepted);
    return value;
}