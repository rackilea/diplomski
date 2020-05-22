System.out.println("Local class constructors array length: " + 
                   localClazz.getDeclaredConstructors().length);
System.out.println("About to create local class instance reflectively");

try {
    localClassInstance = localClazz
            .getDeclaredConstructor(LocalClassInstantiationTest.class)
            .newInstance(this);
    localClassInstance.print();
} catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
    e.printStackTrace();
}