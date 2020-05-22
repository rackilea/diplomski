public class ReadableByteArrayOutputStream extends ByteArrayOutputStream
{
    /**
     * Converts the data in the current stream into a ByteArrayInputStream.
     * The resulting stream wraps the existing byte array directly;
     * further writes to this output stream will result in unpredictable
     * behavior.
     */
    public InputStream toInputStream()
    {
        return new ByteArrayInputStream(array, 0, count);
    }
}