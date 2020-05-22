static class ReflexiveBaker {
    public static <T extends Bakery> T bake(Class<T> order) {
        try {
            return order.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                    | InvocationTargetException e) {
            throw new AssertionError("Class could not be instantiated.", e);
        }
    }
}