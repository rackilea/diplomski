public class Test<T> {

    public void a(int initial_capacity) {
        @SuppressWarnings("unchecked")
        T[] backing_array;
        backing_array = (T[]) new Object[initial_capacity];
    }
}