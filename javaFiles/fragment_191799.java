import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

import java.util.HashMap;

public class JavaClass {

    public static void processRendered(@ClosureParams(
            value = FromString.class,
            options = {"java.util.Map<java.lang.String,java.lang.Object>"}) Closure closure) {

        closure.call(new HashMap<String, Object>());
    }
}