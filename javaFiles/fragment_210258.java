public class HomemadeStack {
    private Object[] theStack;
    @postcondition: stack is not empty, and contains one more element
    public void push(Object o) {
        // implementation specific to an array
    }
    @precondition: stack is not empty
    @postcondition stack contains one less element
    public Object pop() throws StackUnderflowException {
        // implementation specific to an array
    }
    @postcondition: the stack is empty (isEmpty() will return true)
    public void clear() {
        // again, implementation specific to an array
    }
    @returns: true only if there are no objects on the stack
    public boolean isEmpty() {
        // again, implementation specific to an array
    }
}