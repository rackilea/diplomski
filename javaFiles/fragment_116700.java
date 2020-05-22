HttpResponse response = httpClient.execute(uriRequest);
HttpEntity entity = response.getEntity();
if(entity != null) {
    InputStream in = new PushbackInputStream(entity.getContent());
    try {
        int firstByte=in.read();
        if(firstByte != -1) {
            in.unread(firstByte);
            // json parsing
        }
        else {
            // empty
        }
    }
    finally {
        // Don't close so we can reuse the connection
        EntityUtils.consumeQuietly(entity);
        // Or, if you're sure you won't re-use the connection
        in.close();
    }
}