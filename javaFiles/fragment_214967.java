List<A> as = Lists.newArrayList(new A(1, "a"), new A(3, "c"), new A(2, "b"));
List<B> bs = Lists.newArrayList(new B(1, 2), new B(3, 6), new B(5, 10));

Function<WithKey, Object> toKey = new Function<WithKey, Object>() {
    @Override public Object apply(WithKey input) { return input.key(); }
};
ImmutableListMultimap<Object, AbstractWithKey> index = 
    Multimaps.index(Iterables.concat(as, bs), toKey);