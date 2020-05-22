class MyHandler implements InvocationHandler {
  Object invoke(Object proxy, Method method, Object[] args) {
    if (method is the one you want to change) {
       do whatever
    else
       return method.invoke(originalObject, args);
  }
}