public class ArrayStack<T> {
    protected int sp; // empty stack
    protected T[] head; // array
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        sp = -1;
        size = 24; // sets the default size of the stack
        head = (T[]) new Object[size];
    }

    public boolean isFull() {
        return sp == this.size -1;
    }

    public boolean isEmpty() {
        return sp == -1;
    }

    public void push(T t) {
        if (!isFull())
            head[++sp] = t;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        } else
            return head[sp--]; // LINE 30
    }

    public static void main(String[] args) {
        // Array Implementation
        ArrayStack<String> as = new ArrayStack<String>();

        String s = "Hello";
        String s1 = "World";
        String s2 = "Again";

        as.push(s);
        as.push(s1);
        as.push(s2);

        System.out.println(as.pop()); // LINE 15
        System.out.println();
        System.out.println(as.pop());
        System.out.println();
        System.out.println(as.pop());
        System.out.println();
    }
}