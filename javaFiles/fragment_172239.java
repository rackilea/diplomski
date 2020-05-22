static Globals globals = JsePlatform.standardGlobals();

public static class DoSomething extends ZeroArgFunction {
    @Override
    public LuaValue call() {
        // Return a function compiled from an in-line script
        return globals.load("print 'hello from the other side!'");
    }
}

public static void main(String[] args) throws Exception {
    // Load the DoSomething function into the globals
    globals.set("myHandler", new LuaTable());
    globals.get("myHandler").set("doSomething", new DoSomething());

    // Run the function
    String script = 
            "myVar = myHandler.doSomething();"+
            "myVar()";
    LuaValue chunk = globals.load(script);
    chunk.call();
}