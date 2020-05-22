// Java
public interface ScriptFunction {
  Object method(Object arg1);
}

public class JavaObj {
  public void setCallback(final ScriptFunction callback) {
    callback.method("this will work");
  }
}

// JavaScript
javaObj.setCallback({
  'method': function(oneArg){...} 
});