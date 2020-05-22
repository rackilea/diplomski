interface PeekerView<T> extends Peeker<T> {

    Peeker<T> getPeeker();

    default T peek() {
        return getPeeker().peek();
    }
    default T take() {
        return getPeeker().take();
    }
}