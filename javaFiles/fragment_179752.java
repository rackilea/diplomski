double numA = this.<Double>getValueFromScanner(() -> input.nextDouble(), "number");

char operator = this.<Char>getValueFromScanner(() -> {
    operatorString = input.next();

    if (operatorString.length() != 1) {
        throw new InputMismatchException();
    }

    return operatorString.charAt(0);
}, "operator");

double numB = this.<Double>getValueFromScanner(() -> input.nextDouble(), "number");

// Once your code gets here, all three variables will have valid values.