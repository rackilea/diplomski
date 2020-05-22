URL[] urls={new URL("classloader:/main/foobar.jar")};
    ClassLoader parentClassLoader = this.getClass().getClassLoader();
    URLClassLoader childClassLoader=new URLClassLoader(urls,parentClassLoader);
    Class clazz = childClassLoader.loadClass("test.abc.Main");
    String[] arguments = new String[]{};
    clazz.getMethod("main", arguments.getClass()).invoke(null,arguments);