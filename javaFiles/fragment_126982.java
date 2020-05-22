public class Closer implements AutoCloseable {

    private Reader[] readers;

    public Closer(Reader... readers) {
        this.readers = readers;
    }

    @Override
    public void close() {
        try {
            for (Reader reader : readers) {
                reader.close();
            }
        } catch (IOException ex) {
            // ignore
        }
    }
}