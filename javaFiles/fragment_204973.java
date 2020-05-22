interface HandlerSetter {
  InvocationHandler getHandler();
  void setHandler(InvocationHandler handler);
}

Class<? extends SomeClass> proxy = new ByteBuddy()
  .subclass(SomeClass.class)
  .defineField("handler", InvocationHandler.class, Visibility.PUBLIC)
  .implement(HandlerSetter.class)
  .intercept(FieldAccessor.ofField("handler"))
  .method(ElementMatchers.any())
  .intercept(InvocationHandlerAdapter.toField("handler"))
  .make()
  .load(SomeClass.class.getClassLoader());