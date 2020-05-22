public class CustomClass {

public static class _CustomClass extends ScriptableObject {

    @Override
    public String getClassName() {
        return "CustomClass";
    }

    public int jsFunction_method() {
        System.out.println("from java method");
        return 2;
    }
}

public static void main(String[] args) {
    Context context = Context.enter();
    Global global = new Global(context);
    try {            
        //ScriptableObject.defineClass(global, CustomClass.class); 
        ScriptableObject.defineClass(global, _CustomClass.class);            
        String script = "myInstance = new CustomClass();myInstance+' ';";
        System.out.println(context.evaluateString(global, script, "", 1, null));
        script = "myInstance.method+' '+myInstance.method()";
        System.out.println(context.evaluateString(global, script, "script", 1, null));
        script = "CustomClass.prototype.method=function(){print('overriden from javascript method');return 3;}";
        context.evaluateString(global, script, "", 1, null);
        script = "myInstance.method+' '+myInstance.method();";
        System.out.println(context.evaluateString(global, script, "script", 1, null));
    } 
    catch (Exception e) {
        e.printStackTrace();
    } 
    finally {
        Context.exit();
    }
  }
  }