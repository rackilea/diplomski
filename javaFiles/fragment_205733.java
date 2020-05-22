String string = "ABC";
Class<?> clazz = Integer.class;

Method method = clazz.getDeclaredMethod("valueOf", String.class);

if (method != null) {
    try {
        Object obj = method.invoke(null, string);       
        System.out.println("Success : " + obj);

    } catch (InvocationTargetException ex) {
        System.out.println("Failure : " + string + " is not of type " + 
                                          clazz.getName());
    }
}