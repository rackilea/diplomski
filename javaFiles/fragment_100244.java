public <U> U genericFactory(Constructor<U> classConstructor, Object..args)
  throws
   InstantiationException,
   IllegalAccessException,
   IllegalArgumentException,
   InvocationTargetException {
     return classConstructor.newInstance(args);
 }