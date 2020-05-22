public class Test<T> {

    public void a(int initial_capacity) {
        T[] backing_array;
        @SuppressWarnings("unchecked")
        backing_array = (T[]) new Object[initial_capacity];
    }
}