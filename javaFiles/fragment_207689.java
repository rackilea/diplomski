Object delegate = new ByteBuddy()
  .subclass(ImplDelegate.class)
  .make()
  .load(ImplDelegate.class.getClassLoader())
  .getLoaded()
  .newInstance();