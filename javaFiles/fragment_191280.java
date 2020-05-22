builder = builder
  .defineMethod("getFoo", String.class, Visibility.PUBLIC)
    .intercept(FieldAccessor.ofField("foo"));
  .defineMethod("setFoo", void.class, Visibility.PUBLIC)
    .withParameters(String.class)
    .intercept(FieldAccessor.ofField("foo"));