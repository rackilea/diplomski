private static Class getClass(String classname) throws ClassNotFoundException {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    if(classLoader == null) 
        classLoader = Singleton.class.getClassLoader();
      return (classLoader.loadClass(classname));
}