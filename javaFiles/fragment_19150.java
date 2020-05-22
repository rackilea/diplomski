Class<? extends Runnable> runnableClass;
Class<? extends Enum> enumClass;

Example(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    Class<?> clazz = Class.forName(className);
    runnableClass = clazz.asSubclass(Runnable.class);
    enumClass = clazz.asSubclass(Enum.class);
}