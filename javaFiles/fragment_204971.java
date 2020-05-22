Class<? extends SomeClass> proxy = new ByteBuddy()
  .subclass(SomeClass.class)
  .method(ElementMatchers.any())
  .intercept(InvocationHandlerAdapter.of(invocationHandler))
  .make()
  .load(SomeClass.class.getClassLoader());