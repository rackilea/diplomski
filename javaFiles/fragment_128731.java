public class Stack {

    private Object[] elements;
    private int size = 0;

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference, or you'll have a "memory leak"
        return result;
    }