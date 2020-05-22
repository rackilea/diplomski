private ThreadLocal<PDDocument> localPdDocument = new ThreadLocal<PDDocument>() {
    @Override
    protected PDDocument initialValue() {
        return new PDDocument();
    }
};

...
PDDocument doc = localPdDocument.get();
...