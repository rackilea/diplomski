public class Stack {

    private Array array = new Array();

    public int push(int item) {
        if (!array.addToFront(item)) {
            throw new IllegalStateException("Stack is full");
        }
        /* TODO: It would be better (more idiomatic) for the Array.addToFront()
         * method threw this exception rather than returning a boolean.
         */ 
    }

    public int pop() {
        assertStackNotEmpty();

        // TODO: Remove the item from the front of the array
        //       and shuffle everything along

        return item;
    }

    public int peek() {
        assertStackNotEmpty();
        return array.get(0);
    }

    /**
     * Lecturer's suggested implementation of peek()
     */
    public int top() {
        int item = pop();
        push(item);
        return item;
    }

    private void assertStackNotEmpty() {
       if (array.isEmpty()) {
           throw new EmptyStackException("Stack is empty");
       }
    }
}