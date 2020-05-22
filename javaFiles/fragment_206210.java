class Buffer
{
    private final static int maxSize = 20;

    private byte[] bytes = new byte[maxSize];
    private int idx = 0;
    private bool rxData(byte b)
    {
        bytes[idx++] = b;
        return idx == Addr.bufferBytes;
    }
}