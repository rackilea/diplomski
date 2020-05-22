public int evaluatePostfix(String postfixExpr)
{
    char[] chars = postfixExpr.toCharArray();
    Stack<Integer> stack = new Stack<Integer>();
    for (char c : chars)
    {
        if (isOperand(c))
        {
            stack.push(c - '0'); // convert char to int val
        }
        else if (isOperator(c))
        {
            int op1 = stack.pop();
            int op2;
            int result;
            switch (c) {
                case '_':
                    result = op1 * -1;
                    stack.push(result);
                    break;
                case '*':
                    op2 = stack.pop();
                    result = op1 * op2;
                    stack.push(result);
                    break;
                case '/':
                    op2 = stack.pop();
                    result = op2 / op1;
                    stack.push(result);
                    break;
                case '+':
                    op2 = stack.pop();
                    result = op1 + op2;
                    stack.push(result);
                    break;
                case '-':
                    op2 = stack.pop();
                    result = op2 - op1;
                    stack.push(result);
                    break;
            }
        }
    }
    return stack.pop();
}