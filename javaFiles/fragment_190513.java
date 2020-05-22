@Override
public ServletOutputStream getOutputStream() throws IOException {
    // this is called ONLY in WebLogic
    // created a custom outputstream that wraps your charArray
    return new CustomOutputStream(this.charArray);
}

// custom outputstream to wrap charArray writer
class CustomOutputStream extends ServletOutputStream {

    private WriterOutputStream out;

    public CustomOutputStream(CharArrayWriter writer) {
        // WriterOutputStream has a constructor without charset but it's deprecated, so change the UTF-8 charset to the one you use, if needed
        this.out = new WriterOutputStream(writer, "UTF-8");
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
    }

    @Override
    public void write(int b) throws IOException {
        this.out.write(b);
        this.out.flush(); // it doesn't work without flushing
    }
}