ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");
String ss[] = (String[]) js.eval(
    "(function() {" +
    "  var a = java.lang.reflect.Array.newInstance(java.lang.String, 3);" +
    "  a[0] = 'foo';" +
    "  a[1] = 'bar';" +
    "  a[2] = 'gah';" +
    "  return a;" +
    "})()");
System.out.println(Arrays.toString(ss)); // => [foo, bar, gah]