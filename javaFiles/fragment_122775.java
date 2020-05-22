byte[] buffer = new byte[100];
int offset = 0;

while(true) {
    // Read as many bytes as possible, up to remaining space in buffer
    int bytes_read = source.read(buffer, offset, buffer.length - offset);

    if (bytes_read >= 0) {
        // Accumulate number of bytes that has been read.
        offset += bytes_read;

        if (offset == buffer.length) {
            // Buffer is full, send it.
            sink.write(buffer, 0, buffer.length);

            // Clear buffer for next frame 
            offset = 0;
        }
    } else {
        break; // End of stream
    }
}