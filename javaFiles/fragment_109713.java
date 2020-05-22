import java.util.Stack;

public class MyStack<T> {
    private Stack<T> stack;

    public MyStack() {
        stack = new Stack<T>();
    }

    public T peek() {
        return stack.peek();
    }

    public void push(T item) {
        stack.push(item);
    }
}