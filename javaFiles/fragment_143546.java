public HashMap<Class<?>, Method> populateMessageHandler() {
    HashMap<Class<?>, Method> temp = new HashMap<Class<?>, Method>();
    for (Method method : getClass().getMethods()) {
        if (method.getAnnotation(MessageHandler.class) != null) {
            Class<?>[] methodParameters = method.getParameterTypes();
            temp.put(methodParameters[1], method);
        }
    }
    return temp;
}