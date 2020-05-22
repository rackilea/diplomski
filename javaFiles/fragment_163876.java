public static void main(String[] args) {
    parenthesis("1+5*6-3");
    parenthesis("15*5-12-9");
    parenthesis("3*10*16-14-11*2");
    parenthesis("8-5*18+5-13+0*2+14-6*6+1");
    parenthesis("6+5-15*18+14-3-5-3-2-2*8-14+12");
    parenthesis("13-4*6*18+12+8-5*8-4+2+11*6+9-7+6*12*18+8-7+3*1-15*1-12*1-12-14+7-14*9*6");
}

private static void parenthesis(String expression) {
    resultStorage = new long[100][100][100];
    long[] results = parenthesis(expression, 0, 0);
    System.out.println("=====> " + expression + " -> " + results[0] + "/" + results[1]);
}

private static long[][][] resultStorage;

public static long[] parenthesis(String expression, int start, int end) {
    if (resultStorage[start][end][2] == 1)
        return resultStorage[start][end];

    try {
        long parsedLong = Long.parseLong(expression);
        return new long[] { parsedLong, parsedLong, 1 };
    } catch (NumberFormatException e) {
        //
    }

    long[] result = { Integer.MAX_VALUE, Integer.MIN_VALUE, 1 };
    for (int i = 1; i < expression.length() - 1; i++) {
        if (Character.isDigit(expression.charAt(i)))
            continue;
        long[] left = parenthesis(expression.substring(0, i), start, start + i);
        long[] right = parenthesis(expression.substring(i + 1, expression.length()), start + i + 1, end);
        for (int li = 0; li < 2; li++) {
            for (int ri = 0; ri < 2; ri++) {
                switch (expression.charAt(i)) {
                case '+':
                    result[0] = Math.min(result[0], left[li] + right[ri]);
                    result[1] = Math.max(result[1], left[li] + right[ri]);
                    break;
                case '-':
                    result[0] = Math.min(result[0], left[li] - right[ri]);
                    result[1] = Math.max(result[1], left[li] - right[ri]);
                    break;
                case '*':
                    result[0] = Math.min(result[0], left[li] * right[ri]);
                    result[1] = Math.max(result[1], left[li] * right[ri]);
                    break;
                case '/':
                    if (right[ri] != 0)
                        result[0] = Math.min(result[0], left[li] / right[ri]);
                    if (right[ri] != 0)
                        result[1] = Math.max(result[1], left[li] / right[ri]);
                    break;
                }
            }
        }
    }

    resultStorage[start][end] = result;
    return result;
}