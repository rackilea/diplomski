public <T> T getNewInstance(final Class<T> clazz, Object... constructorParameters) throws InstantiationException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
    Class[] parameterTypes = new Class[constructorParameters.length];
    for(int i = 0; i < constructorParameters.length; i++) {
        parameterTypes[i] = constructorParameters[i].getClass();
    }

    Constructor<T> constructor = clazz.getConstructor(parameterTypes);
    return constructor.newInstance(constructorParameters);
}