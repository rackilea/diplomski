.flatMapIterable(new Function<Container, Iterable<A>>() {
    @Override public Iterable<A> apply(Container c) {
        return c.getListOfA();
    }
})
.flatMapIterable(new Function<Iterable<A>, Iterable<Base>>() {
    @Override public Iterable<Base> apply(Iterable<A> a) {
        return Ix.<Base>just(a).concatWith(a.getListOfB());
    }
})
.toList()