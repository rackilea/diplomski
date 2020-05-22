public static void main(String[] args) {
    parenthesisOuter("1+5*6-3");
    parenthesisOuter("15*5-12-9");
    parenthesisOuter("3*10*16-14-11*2");
    parenthesisOuter("8-5*18+5-13+0*2+14-6*6+1");
    parenthesisOuter("6+5-15*18+14-3-5-3-2-2*8-14+12");
    parenthesisOuter("13-4*6*18+12+8-5*8-4+2+11*6+9-7+6*12*18+8-7+3*1-15*1-12*1-12-14+7-14*9*6");
    parenthesisOuter("1/0");
    parenthesisOuter("1/1-1");
}

private static void parenthesisOuter(String expression) {
    Object[] results = parenthesis(expression);
    System.out.println(expression + " -> " + results[MINVAL] + "=" + results[MINEXPR] + " "
            + results[MAXVAL] + "=" + results[MAXEXPR]);
}

private static Map<String, Object[]> resultMap = new HashMap<>();

private static final int MINVAL = 0;
private static final int MAXVAL = 1;
private static final int MINEXPR = 2;
private static final int MAXEXPR = 3;

public static Object[] parenthesis(String expression) {
    Object[] result = resultMap.get(expression);
    if (result != null) {
        return result;
    }

    try {
        Long parsedLong = new Long(expression);
        return new Object[] { parsedLong, parsedLong, expression, expression };
    } catch (NumberFormatException e) {
        // go on, it's not a number
    }

    result = new Object[] { Long.MAX_VALUE, Long.MIN_VALUE, null, null };
    for (int i = 1; i < expression.length() - 1; i++) {
        if (Character.isDigit(expression.charAt(i)))
            continue;
        Object[] left = parenthesis(expression.substring(0, i));
        Object[] right = parenthesis(expression.substring(i + 1, expression.length()));
        doOp(result, (Long) left[MINVAL], expression.charAt(i), (Long) right[MINVAL],
                (String) left[MINEXPR], (String) right[MINEXPR]);
        doOp(result, (Long) left[MINVAL], expression.charAt(i), (Long) right[MAXVAL],
                (String) left[MINEXPR], (String) right[MAXEXPR]);
        doOp(result, (Long) left[MAXVAL], expression.charAt(i), (Long) right[MINVAL],
                (String) left[MAXEXPR], (String) right[MINEXPR]);
        doOp(result, (Long) left[MAXVAL], expression.charAt(i), (Long) right[MAXVAL],
                (String) left[MAXEXPR], (String) right[MAXEXPR]);
    }

    resultMap.put(expression, result);
    return result;
}

private static void doOp(Object[] result, Long left, char op, Long right, String leftExpression,
        String rightExpression) {
    switch (op) {
    case '+':
        setResult(result, left, op, right, left + right, leftExpression, rightExpression);
        break;
    case '-':
        setResult(result, left, op, right, left - right, leftExpression, rightExpression);
        break;
    case '*':
        setResult(result, left, op, right, left * right, leftExpression, rightExpression);
        break;
    case '/':
        if (right != 0) {
            setResult(result, left, op, right, left / right, leftExpression, rightExpression);
        }
        break;
    }
}

private static void setResult(Object[] result, Long left, char op, Long right, Long leftOpRight,
        String leftExpression, String rightExpression) {
    if (result[MINEXPR] == null || leftOpRight < (Long) result[MINVAL]) {
        result[MINVAL] = leftOpRight;
        result[MINEXPR] = "(" + leftExpression + op + rightExpression + ")";
    }
    if (result[MAXEXPR] == null || leftOpRight > (Long) result[MAXVAL]) {
        result[MAXVAL] = leftOpRight;
        result[MAXEXPR] = "(" + leftExpression + op + rightExpression + ")";
    }
}