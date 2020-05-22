private double readDouble(Scanner scanner, String prompt) {
    while (true) {
        System.out.print(prompt);
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }
    }
}