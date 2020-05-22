class Phrase<P> {
    abstract <X> X memo(Function<P, X> f);
}
class Joke extends Phrase<Joke> {
    @Override
    <X> X memo(Function<Joke, X> f) {...}
}