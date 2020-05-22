class KnownSizeInputStreamBody extends InputStreamBody {   
    private final long contentLength;

    public KnownSizeInputStreamBody(InputStream in, long contentLength, ContentType contentType) {
        super(in, contentType);
        this.contentLength = contentLength;
    }

    @Override
    public long getContentLength() {
        return contentLength;
    }
}