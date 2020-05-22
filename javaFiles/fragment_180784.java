private static int operate(Integer a, Integer b, char operator) {
    switch(operator) {
        case '-':
            return b - a;
        case '+':
            return a + b;
        default:
            throw new IllegalStateException("Unknown operator '"+operator+"'");
    }
}