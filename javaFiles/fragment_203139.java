String script = "int y = x * x; System.out.println(\"** value of y ** :: \" + y ); ";

def ts = System.currentTimeMillis()
for(int i=0;i<100;i++){
    GroovyShell gs = new GroovyShell();
    Script evalScript = gs.parse("void evalMethod() {" + script + "}");
    // bind variables
    Binding binding = new Binding();
    binding.setVariable("x", i);
    evalScript.setBinding(binding);
    // invoke eval method
    evalScript.invokeMethod("evalMethod", null);
}
println ">> ${System.currentTimeMillis() - ts} millis"