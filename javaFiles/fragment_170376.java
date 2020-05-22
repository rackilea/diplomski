private volatile boolean closed = false;
private Closable/*e.g. ObjectOutputStream */ onClose = ...;


public void close() {
    closed = true;
    try {
        if (onCLose != null) onClose.close();
    } catch(IOException ignored) {
    }
}


private Object readObject() {
    try {
         if (closed) throw new IllegalStateException();
         return steam.readObject();
    } finally {
         if (closed) throw new IllegalStateException();
    }
}