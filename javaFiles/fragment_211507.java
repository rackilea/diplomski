public void doMyClassLogicVersion1() {
    ClassLoader loader = URLClassLoader.newInstance(
     new URL[] { yourURL1 },   
     getClass().getClassLoader()
    );
    Class<?> clazz = Class.forName("mypackage.MyClass", true, loader);
    // Avoid Class.newInstance, for it is evil.
    Constructor<?> ctor = runClass.getConstructor();
    Object obj = ctor.newInstance();

    String methodName = "getName";

    java.lang.reflect.Method method;
    try {
      method = clazz.getMethod(methodName, param1.class, param2.class, ..);
    } catch (SecurityException e) {
      // ...
    } catch (NoSuchMethodException e) {
      // ...
    }

    try {
      method.invoke(obj, arg1, arg2,...);
    } catch (IllegalArgumentException e) {
      // ...
    } catch (IllegalAccessException e) {
      // ...
    } catch (InvocationTargetException e) {
      // ...
    }
}

public void doMyClassLogicVersion2() {
    ClassLoader loader = URLClassLoader.newInstance(
     new URL[] { yourURL2 },   
     getClass().getClassLoader()
    );
    Class<?> clazz = Class.forName("mypackage.MyClass", true, loader);
    // Avoid Class.newInstance, for it is evil.
    Constructor<?> ctor = runClass.getConstructor();
    Object obj = ctor.newInstance();

    String methodName = "getName";

    java.lang.reflect.Method method;
    try {
      method = clazz.getMethod(methodName, param1.class, param2.class, ..);
    } catch (SecurityException e) {
      // ...
    } catch (NoSuchMethodException e) {
      // ...
    }

    try {
      method.invoke(obj, arg1, arg2,...);
    } catch (IllegalArgumentException e) {
      // ...
    } catch (IllegalAccessException e) {
      // ...
    } catch (InvocationTargetException e) {
      // ...
    }
}