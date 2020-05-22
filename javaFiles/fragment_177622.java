String script = "function sum(x, y) {\n" +
                "    return x + y\n" +
                "}\n" +
                "function diff() {\n" +
                "    return arguments[0] - arguments[1]\n" +
                "}\n" +
                "mult = function(x, y) {\n" +
                "    return x * y\n" +
                "}\n";
ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
Bindings vars = engine.createBindings();
engine.eval(script, vars);
for (Entry<String, Object> var : vars.entrySet()) {
    String name = var.getKey();
    Object value = var.getValue();
    if (value instanceof JSObject) {
        JSObject jsObj = (JSObject) value;
        if (jsObj.isFunction()) {
            String funcHeader = jsObj.toString().replaceFirst("(?s)\\{.*", "");
            System.out.println("function '" + name + "' defined as: " + funcHeader);
            System.out.println(name + "(5,7) = " + jsObj.call(null, 5, 7));
        }
    }
}