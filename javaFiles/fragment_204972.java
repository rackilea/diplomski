Class<? extends SomeClass> proxy = new ByteBuddy()
  .subclass(SomeClass.class)
  .defineField("handler", InvocationHandler.class, Visibility.PUBLIC)
  .method(ElementMatchers.any())
  .intercept(InvocationHandlerAdapter.toField("handler"))
  .make()
  .load(SomeClass.class.getClassLoader());