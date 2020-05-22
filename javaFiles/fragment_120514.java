@SuppressWarnings("unchecked")
public static <S extends BaseClass, C extends S> Predicate<C> getConstraints(Class<C> clazz) {
    if (clazz == BaseClass.class) {
        return (Predicate<C>) constraints.getOrDefault(BaseClass.class, x -> true);
    }
    Class<S> superClass = (Class<S>) clazz.getSuperclass();
    Predicate<C> p1 = (Predicate<C>) constraints.getOrDefault(clazz, x -> true);
    Predicate<S> p2 = getConstraints(superClass);
    return p1.and(p2);
}