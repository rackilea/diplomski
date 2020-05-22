public interface Immutable<T> {

    public interface Builder<T> {
        public T build();
    }

    public Builder<T> builder(); 
}