FunctionObject javascriptFunction = new MyFunctionObject(javascriptFunctionName, javaMethod, parentScope);
boundScope.put(javascriptFunctionName, boundScope, javascriptFunction);


private static class MyFunctionObject extends FunctionObject {

    private MyFunctionObject(String name, Member methodOrConstructor, Scriptable parentScope) {
      super(name, methodOrConstructor, parentScope);
    }

    @Override
    public Object call(Context cx, Scriptable scope, Scriptable thisObj, Object[] args) {
      return super.call(cx, scope, getParentScope(), args);
    }
  }