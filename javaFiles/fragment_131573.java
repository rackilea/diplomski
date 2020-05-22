restTemplate.setErrorHandler(new ResponseErrorHandler() {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return false; // or whatever you consider an error
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        // do nothing, or something
    }
});