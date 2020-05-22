class StackWithComparator<T> implements Stack<T> {

    private Comparator<T> comparator;
    private SimpleStack<T> mins = new SimpleStack<>();
    private SimpleStack<T> data = new SimpleStack<>();

    public StackWithComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void push(T item) {
        data.push(item);
        if (mins.peek() == null || comparator.compare(mins.peek(), item) >= 0) {
            mins.push(item);
        } else {
            mins.push(mins.peek());
        }
    }

    public T pop() {
        mins.pop();
        return data.pop();
    } 

    public T peek() {
        return data.peek();
    }

    public T min() {
        return mins.peek();
    }
}