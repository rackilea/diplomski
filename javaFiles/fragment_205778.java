class MyStack<E> {
    //implementing the stack using a generic single linked list
    class Item {
        E data;
        Item next;
    }
    private Item head;
    private Item tail;
    private int size = 0;
    public MyStack() {
    }
    public int getSize() {
        return this.size;
    }
    public void add(E e) {
        Item temp = new Item();
        temp.data = e;
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
        size++;
    }
    //add the rest of the behavior...
}