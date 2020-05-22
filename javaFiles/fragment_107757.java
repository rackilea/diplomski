ScriptEngineManager factory = new ScriptEngineManager();
ScriptEngine engine = factory.getEngineByName("groovy");
removeSpecialChars = ".replace('a','')";
text = "Dia";
engine.put("first", text);
result = engine.eval("first" + removeSpecialChars);
System.out.println(result);