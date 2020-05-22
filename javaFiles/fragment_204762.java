/* Reads all bytes from the specified stream until it finds a line feed character (\n).
 * For simplicity's sake I'm reading one character at a time.
 * It might be better to use a PushbackInputStream, read more bytes at
 * once, and push the surplus bytes back into the stream...
 */
private static String readLineFrom(InputStream stream) throws IOException {
    InputStreamReader reader = new InputStreamReader(stream);
    StringBuffer buffer = new StringBuffer();

    for (int character = reader.read(); character != -1; character = reader.read()) {
        if (character == '\n')
            break;
        buffer.append((char)character);
    }

    return buffer.toString();
}