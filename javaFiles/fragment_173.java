private StreamingOutput getOut(final byte[] excelBytes) {
    return new StreamingOutput() {
        @Override
        public void write(OutputStream out) throws IOException, WebApplicationException {
            out.write(excelBytes);
        }
    };
}