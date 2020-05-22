private static Object getField(Object c, String name) throws IllegalAccessException {
        while (c != null && !c.getClass().getName().toLowerCase().equals("java.lang.object")) {
            try {
                Field field = c.getClass().getDeclaredField(name);
                field.setAccessible(true);
                return field.get(c);
            } catch (NoSuchFieldException e) {
                c = c.getClass().getSuperclass();
            }
        }
        return null;
    }