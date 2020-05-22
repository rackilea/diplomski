class SingletonAccessor {
  static Object get() {
    Class<?> clazz = ClassLoader.getSystemClassLoader()
                                .findClass("pkg.Singleton");
    Field field = clazz.getDeclaredField("instance");
    synchronized (clazz) {
      Object instance = field.get(null);
      if(instance == null) {
        instance = clazz.newInstance();
        field.set(null, instance);
      }
      return instance;
    }
  }
}