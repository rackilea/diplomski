public class Stack<T> {

    private final T[] data;
    private int top;

    public Stack(final T[] data) {
        this.data = data;
        top = -1;
    }

    public void Push(final T value) {
        top++;
        data[top] = value;
    }

    public T pop() {
        return data[top--];
    }

    public T top() {
        return data[top];
    }
}