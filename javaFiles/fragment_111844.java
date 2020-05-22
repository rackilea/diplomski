ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("nashorn");

    engine.put("var1", new BigDecimal("3.14"));

    try {
        engine.eval("print(var1.multiply(var1))");
        BigDecimal x = (BigDecimal) engine.eval("var1.multiply(var1)");
        double y = (Double) engine.eval("var1 * var1");
    } catch (ScriptException e) {
        e.printStackTrace();
    }