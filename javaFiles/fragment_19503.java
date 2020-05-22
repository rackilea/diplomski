private static boolean isOperandChar(final char c) {
    return Character.isDigit(c) || c == '.';
}

private static String[] splitPostfixExpression(final String input) {
    final List<String> postfixExpression = new ArrayList<>();
    boolean encounteredOperandStart = false;
    String currentOperand = "";
    for(final char c : input.toCharArray()) {
        if(encounteredOperandStart) {
            if(isOperandChar(c)) {
                currentOperand += c;
            } else {
                // we've encountered an operator char after reading one or more operand characters, 
                // thus we know this character is an operator and not an operand sign
                postfixExpression.add(currentOperand);
                postfixExpression.add(String.valueOf(c));
                currentOperand = "";
                encounteredOperandStart = false;
            }
        } else {
            if(isOperandChar(c)) {
                encounteredOperandStart = true;
            }
            currentOperand += c;
        }
    }
    if(!currentOperand.isEmpty()) {
        postfixExpression.add(currentOperand);
    }
    return postfixExpression.toArray(new String[postfixExpression.size()]);
}