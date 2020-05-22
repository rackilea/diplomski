public class Console extends OutputStream {

    private ListView<String> output;

    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    public Console(ListView<String> output)  {
        this.output = output;
    }

    private void addText() throws IOException {
        String text = buffer.toString("UTF-8");
        buffer.reset();
        Platform.runLater( () -> output.getItems().add(text) );
    }

    @Override
    public void write(int b) throws IOException {
        if (b == '\n') {
            addText();
        } else {
            buffer.write(b);
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        int bound = off + len;
        for (int i = off; i < bound; i++) {
            if (b[i] == '\n') {
                buffer.write(b, off, i - off);
                addText();
                off = i + 1;
            }
        }
        assert(off <= bound);
        buffer.write(b, off, bound - off);
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void flush() throws IOException {
        // outputs all currently buffered data as a new cell, without receiving
        // a newline as otherwise is required for that
        addText();
    }

    @Override
    public void close() throws IOException {
        flush();
        buffer.close();
    }
}