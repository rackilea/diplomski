public static void main(String[] args) throws ScriptException {

    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    String x = "(3+5)x + x^(6/2)";

    // can also be extended to expressions like 3+5*5 with 
    // Pattern.compile("\\(\\d+([+/*-]\\d+)+\\)")
    Pattern simpleArithmeticExpr = Pattern.compile("\\(\\d+[+/]\\d+\\)"); 
    Matcher matcher = simpleArithmeticExpr.matcher(x);
    StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
        String expr = matcher.group();
        String evaluatedExpr = String.valueOf(engine.eval(expr));
        matcher.appendReplacement(sb, evaluatedExpr );
    }
    matcher.appendTail(sb);
    System.out.println(sb); // 8x + x^3

}