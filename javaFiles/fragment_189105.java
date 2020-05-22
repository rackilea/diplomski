private static void readCharacters(Reader reader)
        throws IOException {
    int r;
    while ((r = reader.read()) != -1) {
        char ch = (char) r;
        doSomethingWithChar(ch);
    }
}