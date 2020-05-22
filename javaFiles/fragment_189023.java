private final Map<Class<?>, Set<? extends Something>> sets = new HashMap<>();

public Container() {
    a = createAndPut(A.class);
    b = createAndPut(B.class);
}

private <T extends Something> Set<T> createAndPut(Class<T> type) {
    Set<T> set = new HashSet<>();
    sets.put(type, set);
    return set;
}