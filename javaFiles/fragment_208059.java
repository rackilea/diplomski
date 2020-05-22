import groovy.lang.*;
...

GroovyShell gs = new GroovyShell();
Script script = gs.parse(GROOVY_CODE);
// bind variables
Binding binding = new Binding();
binding.setVariable("context", inParams);
script.setBinding(binding);
// run script
Object ret = script.run();