import java.util.ArrayList;
import java.util.List;

public class Main {

    interface MyStack<T> {
        void push(T item);
        T pop();
    }

    static class MyStackImpl<T> implements MyStack<T> {
        private List<T> items = new ArrayList<T>();
        @Override
        public void push(T item) {
            items.add(item);
        }

        @Override
        public T pop() {
            return items.remove(items.size() - 1);
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStackImpl<Integer>();
        stack.push(42);
        System.out.println(stack.pop());
    }
}