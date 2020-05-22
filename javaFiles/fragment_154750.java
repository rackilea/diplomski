ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine engine = manager.getEngineByName("js");
engine.put("X", 0);
engine.put("expression", "-3*X^2-16*X+2");
engine.put("processed", engine.eval("expression.replace(/(\\w+)\\^(\\w+)/g, 'Math.pow($1,$2)')"));

System.out.println(engine.eval("eval(processed)")); // 2.0