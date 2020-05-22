public void addListener(Container parent) {
  if (parent == null) { return; }
  if ("oracle.forms".equals(parent.getClass().getName())) {
    // Using the class loader of the provided object in the applet
    // get the "class" of the interface you want to implement
    Class desktopListenerClass = Class.forName( "oracle.DesktopListener"
         , true, parent.getClass().getClassLoader());

    // Ask the proxy to create an instance of the class, 
    // providing your implementation through the InvocationHandler::invoke
    Object desktopListener = Proxy.newProxyInstance(
         parent.getClass().getClassLoader()
         , new Class[] { desktopListenerClass }, new InvocationHandler() {

      public Object invoke(Object proxy, Method method, Object[] args) 
        throws Throwable {
        if ("functionName".equals(method.getName())) {
          // do stuff
        }
        return null;
      }
    });

    // do something with your new object
    Method addDesktopListener = parent.getClass().getMethod("");
    addDesktopListener.invoke(parent, desktopListener);
  }
}