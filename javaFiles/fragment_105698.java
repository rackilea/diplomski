private static boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
}

public static String postfixToInfix(String postfix) {
    Stack<String> s = new Stack<String>();
    for (char c : postfix.toCharArray()) {
        if (isOperator(c)) {
            String temp = s.pop();
            s.push('(' + s.pop() + c + temp + ')');
        } else {
            s.push(String.valueOf(c));
        }
    }
    return s.pop();
}