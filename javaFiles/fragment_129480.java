class Phrase {
    ...
    <X> X memo(Function<Phrase, X> f) {...}
}

class Joke extends Phrase {
    ...
    // this is a compiler error
    // (technically, I think it's classified as
    // "override-equivalent", but specified to fail)
    <X> X memo(Function<Joke, X> f) {...}
}