TextIO.write().to("gs://bucket/path").withWritableByteChannelFactory(new FileBasedSink.WritableByteChannelFactory() {
    @Override
    public WritableByteChannel create(final WritableByteChannel channel) throws IOException {
        return Compression.GZIP.writeCompressed(channel);
    }

    @Nullable
    @Override
    public String getMimeType() {
        return MimeTypes.BINARY;
    }

    @Nullable
    @Override
    public String getSuggestedFilenameSuffix() {
        return Compression.GZIP.getSuggestedSuffix();
    }
});