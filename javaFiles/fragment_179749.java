double numA;

while (1) {
    try {
        numA = input.nextDouble();
        break;
    } catch (InputMismatchException e) {
        System.err.printf("Invalid input, try again! Expected number, found '%s'.\n", input.next());
    }
}