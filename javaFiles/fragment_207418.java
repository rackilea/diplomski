interface ReverseLookupSupport<E extends Enum<E>> {
    Class<E> getDeclaringClass();
    default Optional<E> lookup(String name) {
        return Stream.of(getDeclaringClass().getEnumConstants())
          .filter(e->e.name().equals(name)).findFirst();
}