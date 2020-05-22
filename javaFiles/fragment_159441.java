ScriptEngine fScriptEngine = fScriptManager.getEngineByExtension("m");
try {
    String evaledResult = (String) fScriptEngine.eval("D[x^2,x]");
    System.out.println(evaledResult);
} catch (Exception e) {
    e.printStackTrace();
}