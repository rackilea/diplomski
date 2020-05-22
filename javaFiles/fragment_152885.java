// Manager creates engines by mime/language names.
// It has own global scope for engiges created by it.
ScriptEngineManager manager = new ScriptEngineManager();
// Create JavaScript interpreter instance.
// (Nashorn is bundled JavaScript interpreter)
ScriptEngine scope = manager.getEngineByName("JavaScript");
// Define functions you need
String initialScript = "cos = Math.cos;" // ; or \n
    + "sin = Math.sin;"
    + "tg  = Math.tan;"
    + "PI  = Math.PI;"
// Any other function
    + "ctg = function (x) { return cos(x)/sin(x); };";
// ...

try {
    // Add these functions to scope
    scope.eval(initialScript);
} catch(ScriptException ex) {
    // Evaluating exceptions, syntax errors are thrown here
}