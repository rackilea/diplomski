try {
    double d = (double)scope.eval("sin(PI/2) + cos(PI/2)");
    System.out.println("Calculated: " + d);
} catch(ScriptException e) {
    // ...
}