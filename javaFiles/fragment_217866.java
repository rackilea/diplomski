Class<?> runtimeType = new ByteBuddy()
  .withAttribute(TypeAttributeAppender.ForSuperType.INSTANCE)
  .withDefaultMethodAttributeAppender(MethodAttributeAppender.ForInstrumentedMethod.INSTANCE)
  .subclass(Foo.class)
  .method(named("bar")).intercept(SuperMethodCall.INSTANCE)
  .make()
  .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
  .getLoaded();