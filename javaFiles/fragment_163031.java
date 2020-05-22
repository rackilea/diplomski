public class MethodArgumentTest {
    static interface Inf {
    }

    static class One<E extends Inf> implements Inf {
        public <T extends One<E>> T get(T k) {
            return k;
        }
    }

    static class Two<E extends Inf> extends One<E> {
    }

    public static void test() {
        One<Inf> o = new One<Inf>();
        Two<One<Inf>> t = new Two<One<Inf>>();

        o.<Two> get(t); /* unchecked warning */
    }
}