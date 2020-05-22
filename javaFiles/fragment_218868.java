private long calculateExpression(Object op1, Object op2, Object op) throws ScriptException{
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    String expression = "" + op1 + op + op2;
    Integer answer = (Integer) engine.eval(expression);
    return answer.longValue();
}