for (Method m : o.getClass().getMethods()) {
    if (m.getAnnotation(EventHandler.class) != null) {
        Class[] requiredTypes = m.getParameterTypes();
        if (requiredTypes.length == 1 && requiredTypes[0].isAssignableFrom(e.getClass()) {
            m.invoke(o, e);
        }
    }
}