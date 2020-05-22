String script1 = "function hello(myList, name) {" +
                 "  myList.add(name);" +
                 "  print(myList);" +
                 "}";
engine.eval(script1);

ArrayList<String> myList = new ArrayList<>();
myList.add("Hello");

Invocable inv = (Invocable)engine;
inv.invokeFunction("hello", myList, "Scripting!!");