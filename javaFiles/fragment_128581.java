ArrayList<String> myList = new ArrayList<>();
myList.add("Hello");

Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);
bindings.put("myList", myList);

String script1 = "function hello(name) {" +
                 "  myList.add(name);" +
                 "  print(myList);" +
                 "}";
engine.eval(script1);

Invocable inv = (Invocable)engine;
inv.invokeFunction("hello", "Scripting!!" );