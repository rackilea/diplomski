<T, C extends Collection<T>> C fill(Supplier<T> gen, 
                                    int n, 
                                    Supplier<C> factory) { 
    return Stream.generate(gen)
                 .limit(n)
                 .collect(factory, C::add, C::addAll);
}