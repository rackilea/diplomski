public static void ensureMethodThenCall(Object object, String methodName, Object... args) throws InvocationTargetException, IllegalAccessException{
    Method[] marr = object.getClass().getMethods();

    for(Method m: marr){
        if(m.getName().equals(methodName)){
            m.invoke(object, args);
        }
    }
}