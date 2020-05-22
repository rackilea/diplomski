static <T,C extends IModel<T>> void doIndex(Class<C> clz, Iterable<C> items) {}
static {
    Class<? extends IModel<?>> cls = null;
    Collection<? extends IModel<?>> entitiesCollection = null;
    doIndex(cls, null);
    doIndex(null, entitiesCollection);
}