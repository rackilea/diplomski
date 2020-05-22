private void writeChunk(final boolean isFinalChunk) throws HttpResponseException, IOException {
    System.out.println("Writing chunk number " + Integer.toString(chunkCount) + ".");

    try (InputStream inputStream = new ByteBufInputStream(buffer)) {
        int length = Math.min(buffer.readableBytes(), DEFAULT_UPLOAD_CHUNK_SIZE);
        HttpContent contentsend = new InputStreamContent("text/plain", inputStream);

        String URI = location;
        GenericUrl url = new GenericUrl(URI);
        HttpRequest req = requestFactory.buildPutRequest(url, contentsend);

        int offset = chunkCount*DEFAULT_UPLOAD_CHUNK_SIZE;
        long limit = offset + length;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength((long) length);
        headers.setContentRange("bytes " + (length == 0 ? "*" : offset + "-" + (limit - 1)) + (isFinalChunk ? "/" + limit : "/*"));

        req.setHeaders(headers);

        req.setReadTimeout((int) DEFAULT_TIMEOUT);

        try {
            req.execute();
            } 
        catch (HttpResponseException e) {
                if(e.getMessage().equals("308 Resume Incomplete"))
                {
                    ++chunkCount;
                }
                else
                {
                    throw e;
                }
            }
        catch (Exception e) {
            throw e;
        }
    }
}