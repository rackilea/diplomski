public class StreamBuffer
{
    byte[] buffer;

    public StreamBuffer(byte[] data, int count) {
        buffer = new byte[count];
        System.arraycopy(data, 0, buffer, 0, count);
    }
}