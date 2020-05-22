import java.util.function.Function;

public abstract class IOMessage<T> {

    private IOMessage() {
    }

    public abstract <M> M match(Function<Success<T>, M> s,
            Function<Error<T>, M> e, Function<Quit<T>, M> q);

    public static final class Success<S> extends IOMessage<S> {
        public final S payload;

        public <M> M match(Function<Success<S>, M> s, Function<Error<S>, M> e,
                Function<Quit<S>, M> q) {
            return s.apply(this);
        }

        public Success(S payload) {
            this.payload = payload;
        }

    }

    public static final class Error<S> extends IOMessage<S> {
        public final Throwable t;

        public <M> M match(Function<Success<S>, M> s, Function<Error<S>, M> e,
                Function<Quit<S>, M> q) {
            return e.apply(this);
        }

        public Error(Throwable t) {
            this.t = t;
        }
    }

    public static final class Quit<S> extends IOMessage<S> {
        public <M> M match(Function<Success<S>, M> s, Function<Error<S>, M> e,
                Function<Quit<S>, M> q) {
            return q.apply(this);
        }

        public Quit() {
        }
    }

}