String script = "int y = x * x; System.out.println(\"** value of y ** :: \" + y ); ";
GroovyShell gs = new GroovyShell();
Class<Script> scriptClass = gs.parse("void evalMethod() {" + script + "}").getClass();

def ts = System.currentTimeMillis()
for(int i=0;i<100;i++){
    Script evalScript = scriptClass.newInstance();
    // bind variables
    Binding binding = new Binding();
    binding.setVariable("x", i);
    evalScript.setBinding(binding);
    // invoke eval method
    evalScript.invokeMethod("evalMethod", null);
}
println ">> ${System.currentTimeMillis() - ts} millis"