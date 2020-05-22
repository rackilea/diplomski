URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] {
       new URL(
           "file:///D:/"
       )
});

Class clazz = urlClassLoader.loadClass("deep");