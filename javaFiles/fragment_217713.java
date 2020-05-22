while (continueLoop) {
    System.out.println("Enter x1: ");
    try {
        x1 = reader.nextInt();//this does not consume the last newline
        continueLoop = false;
    } catch (InputMismatchException e) {
        System.out.println("Please only enter numbers");
    }
    reader.nextLine();//You can consume it using nextLine()
}