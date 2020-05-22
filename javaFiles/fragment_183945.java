static <T extends IModel<T>> void doIndex(Class<T> clz, Iterable<T> items) {}
static {
    Class<? extends IModel<?>> cls = null;
    Collection<? extends IModel<?>> entitiesCollection = null;
    doIndex((Class)cls, (Collection)entitiesCollection); // has a warning, but compiles
}