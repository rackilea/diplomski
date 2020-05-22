public static class HandlerMap<T> extends HashMap<Class<? extends T>, BiFunction<T, T, Boolean>> {
    @SuppressWarnings("unchecked")
    <U extends T> BiFunction<U, U, Boolean> getStrict(Class<? extends U> key) {
        return (BiFunction<U, U, Boolean>) get(key);
    }
}

private static HandlerMap<Object> ARRAY_EQUALS_HANDLER = new HandlerMap<>();

static {
    ARRAY_EQUALS_HANDLER.put(Object[].class, (l, r) -> Arrays.equals((Object[]) l, (Object[]) r));
    ARRAY_EQUALS_HANDLER.put(boolean[].class, (l, r) -> Arrays.equals((boolean[]) l, (boolean[]) r));

    //WARNING - type safety breaks here
    ARRAY_EQUALS_HANDLER.put(int[].class, (l, r) -> Arrays.equals((boolean[]) l, (boolean[]) r));

}
public static void main(String[] args) throws Exception {
    BiFunction<int[], int[], Boolean> biFunction = ARRAY_EQUALS_HANDLER.getStrict(int[].class);
}