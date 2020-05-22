ScriptEngine jsEngine = new ScriptEngineManager().getEngineByName("JavaScript");
jsEngine.put("value1", 8);
jsEngine.put("value2", 9);
String script = "if(value1 + 2 > value2) {'Foo'} else {'Bar'}";
final Object result = jsEngine.eval(script);
System.out.println(result);  //yields "Foo" String