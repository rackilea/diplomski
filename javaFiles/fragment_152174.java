public static ObjectOutputStream newInstance(
    final int myData, final OutputStream out
) throws IOException {
    return new ObjectOutputStream(out) {
        @Override
        protected void writeStreamHeader() throws IOException {
            write(myData);
            super.writeStreamHeader();
        }
    };
}