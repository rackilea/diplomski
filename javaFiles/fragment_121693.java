/*
 ...
 * @since 4.0 (method existed in 3.2 but was completely broken)
 */
public static <E> Collection<E> removeAll(final Collection<E> collection, final Collection<?> remove) {
    return ListUtils.removeAll(collection, remove);
}