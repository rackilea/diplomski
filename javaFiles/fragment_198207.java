private static boolean isFunction(ScriptEngine engine, String name)
    throws ScriptException {
  String test = "typeof " + name
      + " === 'function' ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE";
  return (Boolean) engine.eval(test);
}