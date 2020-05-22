public static boolean evaluate(String input)
{
  try
  {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    Object result = engine.eval("eval('" + input + "');");
    return Boolean.TRUE.equals(result);
  }
  catch (ScriptException e)
  {
    throw new IllegalArgumentException("invalid format");
  }
}