Map<Integer, Supplier<X>> map = new HashMap<>();
map.put(1, A::new); // () -> new A()
map.put(2, B::new); // () -> new B()

X createObject(int type) {
    Supplier<X> supplier = map.get(type);
    if (supplier == null) return null;
    return supplier.get();
}