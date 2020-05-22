ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

final String inputSctipt = "T.methodA('p1Value').methodB('p2Value','p3Value').methodC('p4Value')";

try {
    engine.eval(jsLib);

    Map<String, Object> result = (Map<String, Object>)engine.eval(inputSctipt);
    System.out.println("Script result:\n" + result.get("p1"));
} catch (ScriptException e) {
    e.printStackTrace();
}