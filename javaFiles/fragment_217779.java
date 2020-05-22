class Saver<T> {
    T value;

    Saver(T value) {
        this.value = value;
    }

    T save(T value) {
        T old = this.value;
        this.value = value;
        return old;
    }
}