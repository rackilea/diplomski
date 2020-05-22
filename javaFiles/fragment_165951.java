public static void main(String[] args) {
    Reflections reflections = new Reflections();
    ReflectionsInterface reflectionsProxy = reflections
            .createProxy(ReflectionsInterface.class);
    for (int i = 0; i < 10000; i++)
        invokeMethod(reflectionsProxy, ReflectionsInterface.class,
                "doSomething");

    invokeMethod(new Object(), ReflectionsInterface.class, "doSomething");
}