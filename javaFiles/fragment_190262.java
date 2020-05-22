package grimbo.test.rhino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class InvokeFunction {
    public static void main(String[] args) {
        String sb = "var sampleProcessor = {\n" + "    process: function(data){\n    out.println(0); return 1+1;\n    }\n" + "}";

        Context cx = Context.enter();
        Scriptable scope = cx.initStandardObjects();

        Object out = Context.javaToJS(System.out, scope);
        ScriptableObject.putProperty(scope, "out", out);

        cx.evaluateString(scope, sb.toString(), "Test", 1, null);

        // get the sampleProcessor object as a Scriptable
        Scriptable processor = (Scriptable) scope.get("sampleProcessor", scope);
        System.out.println(processor);

        // get the process function as a Function object
        Function processFunction = (Function) processor.get("process", processor);
        System.out.println(processFunction);

        // execute the process function
        Object ob = cx.evaluateString(scope, "sampleProcessor.process()", "Execute process", 1, null);
        System.out.println(ob);
    }
}