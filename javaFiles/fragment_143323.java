new ByteBuddy()
  .subclass(Singleton.class)
  .method(any())
  .intercept(new Object() {
    @RuntimeType
    Object intercept(@Origin Method m, 
                     @AllArguments Object[] args) throws Exception {
      Object singleton = SingletonAccessor.get();
      return singleton.getClass()
        .getDeclaredMethod(m.getName(), m.getParameterTypes())
        .invoke(singleton, args);
    }
  })
  .make()
  .load(Singleton.class.getClassLoader(), 
        ClassLoadingStrategy.Default.INJECTION)
  .getLoaded()
  .newInstance();