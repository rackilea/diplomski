import groovy.lang.Binding;
import groovy.lang.Script;
import groovy.lang.GroovyShell;

Binding binding = new Binding();
binding.setProperty("status", "part-time");
GroovyShell shell = new GroovyShell(binding);
Script script = shell.parse(" status == 'part-time' || status == 'hourly' ");
Object result = script.run();