public class Phrase<P extends Phrase<P>> {
    private final ConcurrentHashMap<Function<P, ?>, Object> memos;
    public final String text;
    public <X> X memo(Function<P, X> app) {
        return (X) memos.computeIfAbsent(app, unused -> app.apply((P) this));
    }
}

class Joke extends Phrase<Joke> {...}