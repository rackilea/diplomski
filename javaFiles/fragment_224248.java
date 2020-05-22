class Test {

    public static void main(String[] args) {
         System.out.println(computeOne(4, "2", "/"));  // 2
         System.out.println(computeOne(4, "2", "*"));  // 8
         System.out.println(computeOne(4, "2", "-"));  // 2
         System.out.println(computeOne(4, "2", "+"));  // 6
    }

    private static int computeOne(int res, String operand, String operation) {
        return Operation.getOperationBySymbol(operation)
                        .getBinaryOperator()
                        .apply(res, Integer.parseInt(operand));
    }

    private enum Operation {
        // operation = symbol, action
        MULTIPLICATION("*", (a, b) -> a * b),
        ADDITION("+", (a, b) -> a + b),
        SUBTRACTION("-", (a, b) -> a - b),
        DIVISION("/", (a, b) -> a / b);

        private final BinaryOperator<Integer> binaryOperator;
        private final String symbol;

        Operation(String symbol, BinaryOperator<Integer> binaryOperator) {
            this.symbol = symbol;
            this.binaryOperator = binaryOperator;
        }

        public BinaryOperator<Integer> getBinaryOperator() {
            return binaryOperator;
        }

        public String getSymbol() {
            return symbol;
        }

        public static Operation getOperationBySymbol(String symbol) {
            for (Operation operation : values()) {
                if (operation.getSymbol().equals(symbol)) {
                    return operation;
                }
            }

            throw new IllegalArgumentException("Unknown symbol: " + symbol);
        }
    }

}