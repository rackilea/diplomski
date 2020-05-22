import java.util.function.Function;

public final class Bind <A> implements IO <A> {
    private final OpenBind <?,A> ob;

    public <B> Bind (IO <B> m, Function <B,IO <A>> f) {
        ob = new OpenBind <B,A> (m, f);
    }

    public A run() {
        return (ob.run());
    }

    private final static class OpenBind <Fst,Snd> {
        private final IO <Fst> start;
        private final Function <Fst, IO <Snd>> cont;
        public OpenBind (IO <Fst> m, Function <Fst, IO <Snd>> f) {
            start = m;
            cont = f;
        }
        public final Snd run () {
            Fst x = start.run();
            IO <Snd> c = cont.apply(x);
            return (c.run());
        }
    }
}