String expression = "-3*X^2-16*X+2";
String processed = expression.replaceAll("(\\w+)\\^(\\w+)", "Math.pow($1,$2)");

ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine engine = manager.getEngineByName("js");
engine.put("X", 0);

System.out.println(engine.eval(processed)); // 2.0