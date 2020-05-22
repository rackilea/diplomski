static public String guessContentTypeFromStream(InputStream is)
                    throws IOException {
    // If we can't read ahead safely, just give up on guessing
    if (!is.markSupported())
        return null;

    is.mark(16);
    int c1 = is.read();
    int c2 = is.read();
    int c3 = is.read();
    ...
    int c14 = is.read();
    int c15 = is.read();
    int c16 = is.read();
    is.reset();
    ....