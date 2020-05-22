char operator;

while (1) {
    String operatorString;

    try {
        operatorString = input.next();

        if (operatorString.length() != 1) {
            throw new InputMismatchException();
        }

        operator = operatorString.charAt(0);
        break;
    } catch (InputMismatchException e) {
        System.err.printf("Invalid input, try again! Expected character, found '%s'.\n", operatorString);
    }
}