class Handler<E> {
    Function<Filter, E> getter;
    BiConsumer<Filter, E> setter;
    public Handler(Function<Filter, E> getter, BiConsumer<Filter, E> setter) {
        this.getter = getter;
        this.setter = setter;
    }
}