consumers.put("println", s -> {
    try {
        method.invoke(System.out, s);
    } catch (InvocationTargetException | IllegalAccessException e) {
        throw new RuntimeException(e);
    }
});