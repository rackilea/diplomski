import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.Date;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.kohsuke.groovy.sandbox.SandboxTransformer;

/**
 * Sandboxing: https://github.com/kohsuke/groovy-sandbox
 * http://groovy-sandbox.kohsuke.org/
 *
 */

public class DateExpressionUtils {
    public static Date eval(String expr) {
        try {
            CompilerConfiguration cc = new CompilerConfiguration();
            cc.addCompilationCustomizers(new SandboxTransformer());
            Binding binding = new Binding();
            binding.setProperty("now", new Date());
            GroovyShell sh = new GroovyShell(binding, cc);
            DateExpressionSandbox sandbox = new DateExpressionSandbox();
            sandbox.register();
            try {
                Object resObj = sh.evaluate("use(groovy.time.TimeCategory){" + expr + "}");
                Date res = (Date) resObj;
                return res;
            } finally {
                sandbox.unregister();
            }
        } catch (SecurityException e) {
            throw new SecurityException(String.format("Possible date expression sandbox jailbreak with '%s': '%s'.",
                    expr, e.getMessage()));
        } catch (Exception e) {
            throw new RuntimeException(String.format("Unable to evaluate date expression '%s': '%s'.", expr,
                    e.getMessage()));
        }
    }
}