List<A> input;
Function<A, List<B>> t = new Function<A, List<B>>() {
    @Override public List<B> apply(A input) { 
        return input.myListOfB; 
    }
};
Iterable<B> transform = Iterables.concat(Iterables.transform(input, t));