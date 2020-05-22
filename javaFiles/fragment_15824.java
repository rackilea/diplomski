package sample

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer
import org.junit.Test

import java.lang.reflect.Method

public class GroovyPuzzler {

    public static class X {
        def hello2() {
            throw new RuntimeException("bang!")
        }
    }

    @Test 
    public void test1() {
        def customizer = new ImportCustomizer()
        customizer.addImport('X', 'sample.GroovyPuzzler.X')
        def configuration = new CompilerConfiguration()
        configuration.addCompilationCustomizers(customizer)

        GroovyShell shell = new GroovyShell(configuration)
        Object script = shell.evaluate(
        """
            def sayHello() {
                new X().hello2()
            }
            return this
        """
        )
        try {
           Method m = script.getClass().getMethod("sayHello")
           m.invoke(script)
           fail()
        } catch (Exception e) {
           assertTrue(e.cause.message.equals('bang!'))
        }
    }
}