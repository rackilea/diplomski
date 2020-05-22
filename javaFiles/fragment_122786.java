public class MyClass {
    public boolean evaluate(String stringToEvaluate)
    {
    boolean exprvalue = true;
    for (String string : stringToEvaluate.split("^"))
            {
            exprvalue = exprvalue && evaluateLE(string);
            }
    return exprvalue;
    }

    private boolean evaluateLE(String string) {
        String[] values = string.split("<=");
        if (values.length==2)
        {
            return evaluateVal(values[0]) <= evaluateVal(values[1]); 
        }

        return evaluateOtherLogicalExpr(string);
    }

    private float evaluateVal(String string) {
        if (isExpresion(string)) return evaluateArthmeticalExpr(string);
        if (isVariable(string)) return evaluateVariable(string);

        return Float.parseFloat(string);
    }
}