interface ReverseLookupSupport<E extends Enum<E>> {
    Class<E> getDeclaringClass();
    default E lookup(String name) {
        try {
            return Enum.valueOf(getDeclaringClass(), name);
        } catch(IllegalArgumentException ex) { return null; }
    }
}
enum Test implements ReverseLookupSupport<Test> {
    FOO, BAR
}