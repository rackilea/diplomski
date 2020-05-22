public void doMyClassLogicVersion1() {
    ClassLoader loader = URLClassLoader.newInstance(
     new URL[] { yourURL1 },   
     getClass().getClassLoader()
    );
    Class<?> clazz = Class.forName("mypackage.MyClass", true, loader);
    Class<? extends Runnable> runClass = clazz.asSubclass(Runnable.class);
    // Avoid Class.newInstance, for it is evil.
    Constructor<? extends Runnable> ctor = runClass.getConstructor();
    Runnable doRun = ctor.newInstance();
    doRun.run();
}

public void doMyClassLogicVersion2() {
    ClassLoader loader = URLClassLoader.newInstance(
     new URL[] { yourURL2 },   
     getClass().getClassLoader()
    );
    Class<?> clazz = Class.forName("mypackage.MyClass", true, loader);
    Class<? extends Runnable> runClass = clazz.asSubclass(Runnable.class);
    // Avoid Class.newInstance, for it is evil.
    Constructor<? extends Runnable> ctor = runClass.getConstructor();
    Runnable doRun = ctor.newInstance();
    doRun.run();
}