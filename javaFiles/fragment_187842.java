private static class ByteArrayOutputStreamWithCapacity extends ByteArrayOutputStream {
    public ByteArrayOutputStreamWithCapacity(int size) {
        super(size);
    }

    public synchronized int capacity() {
        return buf.length;
    }
}

void CreateBuffer()
{
    OutputStream out = new ByteArrayOutputStreamWithCapacity(100);
}

int GetBufferSize(OutPutStream out)
{
    return ( (ByteArrayOutputStreamWithCapacity) out). capacity();
}