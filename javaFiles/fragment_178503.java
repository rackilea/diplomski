Object body = new StreamingOutput() {
    @Override
    public void write(OutputStream out)
    throws IOException {
        final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);

        // Stream is filled with data in this method.
        restDAO.readData(bufferedOutputStream);
    }
};

return Response.ok(body, mimeType).header("filename", getFileName()).build();