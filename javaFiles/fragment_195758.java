public void calculate() throws ArithmeticException {
        System.out.println((int)operator);
        if (operator == 47) {// if operator is a forward slash
            if (num2 != 0) {
                sum = (num1 / num2);
            } else {
                throw new ArithmeticException("Arithmetic error");
            }
        } else if (operator == 45) { // -
            sum = (num1 - num2);
        } else if (operator == 43) { // +
            sum = (num1 + num2);
        } else if (operator == 120) {
            sum = (num1 * num2);
        }

    }