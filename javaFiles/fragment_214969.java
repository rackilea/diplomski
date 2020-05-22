Multimap<Object, WithKey> m = ArrayListMultimap.create(); 
for (WithKey w : Iterables.concat(as, bs)) m.put(w.key(), w);

Function<Collection<WithKey>, Tuple> f = 
    new Function<Collection<WithKey>, Tuple>(){
    @Override public Tuple apply(Collection<WithKey> input) {
        Iterator<WithKey> iterator = input.iterator();
        return new Tuple(iterator.next(), iterator.next());
    } };
Map<Object, Tuple> result = Maps.transformValues(m.asMap(), f);