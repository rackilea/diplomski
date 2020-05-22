public class ArrayBuffer extends Buffer {
    public ArrayBuffer(final int bufferDataType) {
        super(GL15.GL_ARRAY_BUFFER, bufferDataType);
    }

    public ArrayBuffer create() {
        super.create();
        return this;
    }
    public ArrayBuffer bind() {
        super.bind();
        return this;
    }
}

public class StaticDrawArrayBuffer  extends ArrayBuffer {
    public StaticDrawArrayBuffer() {
        super(GL15.GL_STATIC_DRAW);
    }


    public StaticDrawArrayBuffer bind() {
        super.bind();
        return this;
    }
}