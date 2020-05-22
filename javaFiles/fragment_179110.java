...
__callClassForName(className, booleanParameter, loader);
...

private static Class __callClassForName(String className, boolean bParameter, ClassLoader loader) {
    MyProxy.call(className);
    return Class.forName(className, bParameter, loader);
}