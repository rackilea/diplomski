class ByteArrayTransportOutputStream extends TransportOutputStream {

    private ByteArrayOutputStream outputStream;

    @Override
    public void addHeader(String name, String value) throws IOException {
        createOutputStream();
        String header = name + ": " + value + "\n";
        outputStream.write(header.getBytes());
    }

    public byte[] toByteArray() {
         return outputStream.toByteArray();
    }

    @Override
    protected OutputStream createOutputStream() throws IOException {
        if (outputStream == null) {
            outputStream = new ByteArrayOutputStream();
        }
        return outputStream;
    }
}