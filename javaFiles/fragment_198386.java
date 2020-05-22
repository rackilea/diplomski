ClassLoader loader = URLClassLoader.newInstance(
    new URL[] { yourURL },
    getClass().getClassLoader()
);
Class<?> clazz = Class.forName("mypackage.MyClass", true, loader);
Class<? extends Runnable> runClass = clazz.asSubclass(Runnable.class);