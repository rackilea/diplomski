// Member variables
private Context _javaCompEnvContext;
...

// Main thread
_javaCompEnvContext = ctx.lookup("java:comp/comp/env");
...

// Listener thread
BusinessIntf bean = _javaCompEnvContext.lookup("BeanStateful");