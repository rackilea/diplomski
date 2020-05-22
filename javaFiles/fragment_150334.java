Map<String, Supplier<A>> map = new HashMap<>();
map.put("A1", () -> new A1());
map.put("A2", () -> new A2());

...

public A createA(final String id) {
    Supplier<A> supplier = map.get(id);
    if (supplier != null) {
        return supplier.get();
    }
    throw new IllegalArgumentException("unknown id: " + id);
}