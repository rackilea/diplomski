public static int evaluateExpression(String exp) {
    if(exp.charAt(0) == '(' && exp.charAt(exp.length()-1) == ')' 
        && /*These two parenthesis correspond to each other*/) return evaluateExpression(exp.substring(1, exp.length()-1));

    if(/*is Valid Number*/) return Integer.parseInt(exp);

    int n = StringUtils.exprMainOperator(exp);
    char op = exp.charAt(n);
    String preop = exp.substring(0, n), postop = exp.substring(n+1);

    if(op == '+') return evaluateExpression(preop) + evaluateExpression(postop);
    if(op == '-') return evaluateExpression(preop) - evaluateExpression(postop);
    if(op == '*') return evaluateExpression(preop) * evaluateExpression(postop);
    if(op == '/') return evaluateExpression(preop) / evaluateExpression(postop);

    //You shouldn't reach this part of the code
    return -1;
}