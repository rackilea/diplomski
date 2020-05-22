public int parse(String input) {
Scanner scanner = new Scanner(input);

    return consumeLine(scanner);
}

public int consumeLine(Scanner scanner) {
    if( scanner.hasNext("(") ) {
        return consumeExpression(scanner);

    } else if( scanner.hasNext("IF") ) {
        return consumeIf(scanner);
    }
}


public int consumeExpression(Scanner scanner) {
    scanner.next("(");
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    String op = scanner.next("[+-/*]");
    scanner.next(")");

    if( "+".equals(op) ) {
        return a + b;

    } else if( "-".equals(op) ) {
        return a - b;
    } ...

    throw new RuntimeException("parsing error");
}

public int consumeIf(Scanner scanner) {
    scanner.next("IF");
    int exp1 = consumeExpression(scanner);
    int exp2 = consumeExpression(scanner);
    int exp3 = consumeExpression(scanner);
    int exp4 = consumeExpression(scanner);

    if( exp1 < 0 ) {
        return exp2;
    } else if( exp1 == 0 ) {
        return exp3;
    } ...

    throw new RuntimeException("should not be here (TM)");
}