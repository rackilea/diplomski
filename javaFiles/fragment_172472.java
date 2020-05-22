add(new Link<Void>("myPdfLink") {

    private static final long serialVersionUID = 1L;

    @Override
    public void onClick() {
        byte[] data = ... // TODO your data
        final ByteArrayInputStream stream = new ByteArrayInputStream(data);
        IResourceStream resourceStream = new AbstractResourceStream() {                    
            private static final long serialVersionUID = 1L;

            @Override
            public InputStream getInputStream() throws ResourceStreamNotFoundException {
                return stream;
            }

            @Override
            public void close() throws IOException {
                stream.close();
            }

            @Override
            public String getContentType() {
                return "application/pdf";
            }

        };   

        getRequestCycle().scheduleRequestHandlerAfterCurrent(
            new ResourceStreamRequestHandler(resourceStream)
                .setFileName("my-pdf-to-download.pdf")
                .setContentDisposition(ContentDisposition.ATTACHMENT)
                .setCacheDuration(Duration.ONE_SECOND)
        );  

    }

});