@Override
public final void write(final T t, MediaType contentType, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
    ...
    writeInternal(t, outputMessage);
    ...
}