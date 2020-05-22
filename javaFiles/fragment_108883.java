public class SuperClass<E> {

    private class InnerClass<F> {
    }

    private class ProblemClass<G> {
        private InnerClass<G> o;

        public ProblemClass() {
            o = a;
        }
    }

    private InnerClass<E> a;
}