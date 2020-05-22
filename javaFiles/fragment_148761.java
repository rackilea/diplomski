Type mapStringString = new TypeToken<Map<String, String>>(){}.getType();
for (Constructor<?> constructor : MyClass.class.getConstructors()) {
    Type[] parameterTypes = constructor.getGenericParameterTypes();
    if (parameterTypes.length == 1 && parameterTypes[0].equals(mapStringString)) {
        System.out.println("found constructor " + constructor);
    }
}