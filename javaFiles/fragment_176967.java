public final class Example<T extends Example<T>> {

    public interface Interface<M, Subtype extends Interface<M, Subtype>> {
        public M myMethod(Subtype t);

    }
}