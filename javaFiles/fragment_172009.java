private static final List<BiConsumer<Entity,Entity>> ACCESSORS =
    Collections.unmodifiableList(Arrays.asList(
        copyWhenNonNull(Entity::getAreaCode, Entity::setAreaCode),
        copyWhenNonNull(Entity::getOtherProperty, Entity::setOtherProperty)
        /* etc */
));
private static <E,V> BiConsumer<E,E> copyWhenNonNull(
    Function<? super E, ? extends V> getter, BiConsumer<? super E, ? super V> setter) {
    return (src,dst) -> {
        V value = getter.apply(src);
        if(value != null) setter.accept(dst, value);
    };
}