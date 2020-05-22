package test;

import org.mozilla.javascript.*;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

//-- This is the class whose instance method will be made available in a JavaScript scope as a global function.
//-- It extends from ScriptableObject because instance methods of only scriptable objects can be directly exposed
//-- in a js scope as a global function.
public class MyScriptable extends ScriptableObject {

  public static void main(String args[]) throws Exception {

    Context.enter();
    try {
      //-- Create a top-level scope in which we will execute a simple test script to test if things are working or not.
      Scriptable scriptExecutionScope = new ImporterTopLevel(Context.getCurrentContext());
      //-- Create an instance of the class whose instance method is to be made available in javascript as a global function.
      Scriptable myScriptable = new MyScriptable();
      //-- This is not strictly required but it is a good practice to set the parent of all scriptable objects
      //-- except in case of a top-level scriptable.
      myScriptable.setParentScope(scriptExecutionScope);

      //-- Get a reference to the instance method this is to be made available in javascript as a global function.
      Method scriptableInstanceMethod = MyScriptable.class.getMethod("myJavaInstanceMethod", new Class[]{Double.class});
      //-- Choose a name to be used for invoking the above instance method from within javascript.
      String javascriptFunctionName = "myJavascriptGlobalFunction";
      //-- Create the FunctionObject that binds the above function name to the instance method.
      FunctionObject scriptableInstanceMethodBoundJavascriptFunction = new MyFunctionObject(javascriptFunctionName,
              scriptableInstanceMethod, myScriptable);
      //-- Make it accessible within the scriptExecutionScope.
      scriptExecutionScope.put(javascriptFunctionName, scriptExecutionScope,
              scriptableInstanceMethodBoundJavascriptFunction);

      //-- Define a simple test script to test if things are working or not.
      String testScript = "function simpleJavascriptFunction() {" +
              "  try {" +
              "    result = myJavascriptGlobalFunction(12.34);" +
              "    java.lang.System.out.println(result);" +
              "  }" +
              "  catch(e) {" +
              "    throw e;" +
              "  }" +
              "}" +
              "simpleJavascriptFunction();";

      //-- Compile the test script.
      Script compiledScript = Context.getCurrentContext().compileString(testScript, "My Test Script", 1, null);
      //-- Execute the test script.
      compiledScript.exec(Context.getCurrentContext(), scriptExecutionScope);
    } catch (Exception e) {
      throw e;
    } finally {
      Context.exit();
    }
  }

  public Double myJavaInstanceMethod(Double number) {
    return number * 2.0d;
  }

  @Override
  public String getClassName() {
    return getClass().getName();
  }

  private static class MyFunctionObject extends FunctionObject {

    private MyFunctionObject(String name, Member methodOrConstructor, Scriptable parentScope) {
      super(name, methodOrConstructor, parentScope);
    }

    @Override
    public Object call(Context cx, Scriptable scope, Scriptable thisObj, Object[] args) {
      return super.call(cx, scope, getParentScope(), args);
//      return super.call(cx, scope, thisObj, args);
    }
  }
}