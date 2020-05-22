class Foo implements Peeker<T>{

    private Peeker<T> peeker = new PeekerImpl();

    public T peek() {
        return peeker.peek();
    }

    public T take() {
        return peeker.take();
    }
}