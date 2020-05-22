import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * A thread-safe class that will append JSON transaction data to a file.
 */
public class TransactionWriter {
    private static final JsonFactory jsonFactory = new JsonFactory();

    /**
     * Helper method that will read a number of UTF8 characters from an input stream and return them in a string.
     *
     * @param inputStream stream to read from
     * @param charsToRead number of characters to read
     * @return string of read characters
     * @throws IOException when unable to read enough characters from the stream
     */
    private static String readUtf8Chars(InputStream inputStream, int charsToRead) throws IOException {
        // since we know this is UTF8 up front, we can assume one byte per char
        byte[] buffer = new byte[charsToRead];

        // fill the buffer
        int readBytes = inputStream.read(buffer);

        // check that the buffer was actually filled
        if(readBytes < charsToRead)
            throw new IOException("less bytes available to read than expected: " + readBytes + " instead of " + charsToRead);

        // create a string from the buffer
        return new String(buffer, StandardCharsets.UTF_8);
    }


    private final File file;
    private final Object writeLock = new Object();

    /**
     * Constructs a new instance for an output file.
     *
     * @param file file to append to
     */
    public TransactionWriter(File file) {
        this.file = file;
    }

    /**
     * Reads a transaction from the input stream and appends a JSON representation to this instance's output file.
     *
     * @param inputStream stream to read from; will be closed after this method is closed
     * @throws IOException when reading or writing failed
     */
    public void write(InputStream inputStream) throws IOException {
        // since we have multiple threads appending to the same file, synchronize to prevent concurrency issues
        synchronized(writeLock) {

            // open the output stream to append to the file
            try(FileOutputStream outputStream = new FileOutputStream(file, true)) {

                // create the generator for the output stream
                JsonGenerator generator = jsonFactory.createGenerator(outputStream, JsonEncoding.UTF8);

                // write the data to the generator
                generator.writeStartObject();
                generator.writeStringField("length", readUtf8Chars(inputStream, 4).trim());
                generator.writeStringField("MTI", readUtf8Chars(inputStream, 4).trim());
                String bitmap = readUtf8Chars(inputStream, 16);
                generator.writeStringField("stan", readUtf8Chars(inputStream, 8));
                generator.writeStringField("date", readUtf8Chars(inputStream, 14));
                generator.writeStringField("Function Code", readUtf8Chars(inputStream, 3));
                generator.writeEndObject();

            } finally {
                // output stream is closed in try-with-resources, but also close the input stream
                inputStream.close();
            }
        }
    }
}