private static final String NUM = "(\\d*(\\.\\d*)?\\d(e\\d+)?)";

public String solve(String expr) {
    expr = solve(expr, "(" + NUM + "(!|\\+\\+|--))"); //unary operators
    expr = solve(expr, "(" + NUM + "([+-/*]" + NUM + ")+)"); // binary operators
    expr = solve(expr, "((sin|cos|tan)\\(" + NUM + "\\))"); // functions

    return expr;
}

private String solve(String expr, String pattern) {
    Matcher m = Pattern.compile(pattern).matcher(expr);

    // assume a reduce method :String -> String that solve expressions 
    while(m.find()){
        expr = m.replaceAll(reduce(m.group()));
    }
    return expr;
}

//evaluate expression using exp4j, format to 2 decimal places, 
//remove trailing 0s and dangling decimal point
private String reduce(String expr){
    double res = new ExpressionBuilder(expr).build().evaluate();
    return String.format("%.2f",res).replaceAll("0*$", "").replaceAll("\\.$", ""); 
}