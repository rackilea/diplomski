import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class ex1 {

  public static void main(String[] args) {
    Binding binding = new Binding();
    GroovyShell shell = new GroovyShell(binding);

    shell.evaluate("mypath/ex.groovy");
}