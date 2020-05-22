public class Test implements Closeable {
    private RuntimeException ex = new RuntimeException();

    public void doStuff() {
        throw ex;
    }

    public void close() {
        throw ex;
    }
}

try (Test t = new Test()) {
    t.doStuff();
}