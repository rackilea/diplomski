public static void main(String[] args) {
    Stack<Integer> operandStack = new Stack<Integer>();
    Stack<Character> operatorStack = new Stack<Character>();

    String input = "12 + 13 - 4";

    StringTokenizer strToken = new StringTokenizer(input, " ", false);

    while (strToken.hasMoreTokens()) {
        String i = strToken.nextToken();
        int operand;
        char operator;

        try {
            operand = Integer.parseInt(i);
            operandStack.push(operand);
        } catch (NumberFormatException nfe) {
            operator = i.charAt(0);
            operatorStack.push(operator);
        }
    }

    // loop until there is only 1 item left in the operandStack, this 1 item left is the result
    while(operandStack.size() > 1) {
        // some debugging println
        System.out.println("Operate\n\tbefore");
        System.out.println("\t"+operandStack);
        System.out.println("\t"+operatorStack);

        // perform the operations on the stack and push the result back onto the operandStack
        operandStack.push(operate(operandStack, operatorStack));

        System.out.println("\tafter");
        System.out.println("\t"+operandStack);
        System.out.println("\t"+operatorStack);
    }

    System.out.println("Result is: " + operandStack.peek());
}

/**
 * Performs math operations and returns the result. Pops 2 items off the operandStack and 1 off the operator stack. 
 * @param operandStack
 * @param operatorStack
 * @return
 */
private static int operate(Stack<Integer> operandStack, Stack<Character> operatorStack) {
    char op = operatorStack.pop();
    Integer a = operandStack.pop();
    Integer b = operandStack.pop();
    switch(op) {
        case '-':
            return b - a;
        case '+':
            return a + b;
        default:
            throw new IllegalStateException("Unknown operator '"+op+"'");
    }
}