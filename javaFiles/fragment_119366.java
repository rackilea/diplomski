...
scope.put("list", list);
engine.eval(JS, context); // 'context' now contains the 'doit' function.

engine.setContext(context); // <-- Right here
Invocable invocable = (Invocable) engine; // Now the Invocable will use 'context'.
invocable.invokeFunction("doit", "Hello!!!"); //Runs fine

System.out.println(list.size());