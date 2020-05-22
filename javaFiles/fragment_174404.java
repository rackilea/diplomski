public class Buffer {
    private final ObjectInputStream in;

    private Object current;

    public Buffer(ObjectInputStream in) {
        this.in = in;
    }

    public Object peek() {
        if (current == null) {
            current = in.readObject();
        }
        return current;
    }

    public void next() {
        current = in.readObject();
    }
}