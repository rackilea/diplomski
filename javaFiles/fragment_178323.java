public static String readLineWithTerm(Reader reader) throws IOException {
    if (! reader.markSupported()) {
        throw new IllegalArgumentException("reader must support mark()");
    }

    int code;
    StringBuilder line = new StringBuilder();

    while ((code = reader.read()) != -1) {
        char ch = (char) code;

        line.append(ch);

        if (ch == '\n') {
            break;
        } else if (ch == '\r') {
            reader.mark(1);
            ch = (char) reader.read();

            if (ch == '\n') {
                line.append(ch);
            } else {
                reader.reset();
            }

            break;
        }
    }

    return (line.length() == 0 ? null : line.toString());
}