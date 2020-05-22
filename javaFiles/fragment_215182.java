import groovy.lang.Closure;
import groovy.lang.Script;
import groovy.time.Duration;
import groovy.time.TimeCategory;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.kohsuke.groovy.sandbox.GroovyValueFilter;

/**
 * Example sandbox: https://github.com/kohsuke/groovy-sandbox/blob/master/src/test/groovy/org/
 * kohsuke/groovy/sandbox/robot/RobotSandbox.groovy
 *
 */

public class DateExpressionSandbox extends GroovyValueFilter {
    @Override
    public Object filter(Object o) {
        if (o == null || ALLOWED_TYPES.contains(o.getClass()))
            return o;

        if (Class.class.equals(o.getClass()) && ALLOWED_STATIC_CLASSES.contains(o.toString())) {
            return o;
        }

        if (o instanceof Script || o instanceof Closure)
            return o; // access to properties of compiled groovy script

        throw new SecurityException(String.format("Unexpected type: '%s', '%s'.", o.getClass(), o));
    }

    private static final Set<Class<?>> ALLOWED_TYPES = new HashSet<Class<?>>(Arrays.asList(String.class, Integer.class,
            Long.class, Double.class, Boolean.class, Date.class, TimeCategory.class, Duration.class));

    private static final Set<String> ALLOWED_STATIC_CLASSES = new HashSet<>();
    static {
        for (Class<?> cl : ALLOWED_TYPES) {
            ALLOWED_STATIC_CLASSES.add("class " + cl.getCanonicalName());
        }
    }
}