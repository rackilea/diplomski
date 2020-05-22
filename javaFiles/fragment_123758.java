public enum Operation {
 PLUS("+") {
            @Override
            public int apply(int value1, int value2) {
                return value1 + value2;
            }
        },
MULTIPLY("*") {
            @Override
            public int apply(int value1, int value2) {
                return value1 * value2;
            }
};

private final String symbol;

private static final Map<String, Operation> STRING_TO_ENUM = Arrays.stream(Operation.values()).collect(Collectors.toMap(Operation::toString, e -> e));

private Operation(String symbol) {
     this.symbol = symbol;
}

public static Operation fromString(String symbol) {
    return STRING_TO_ENUM.get(symbol);
}

@Override
public String toString() {
    return symbol;
}

public abstract int apply(int value1, int value2);
}