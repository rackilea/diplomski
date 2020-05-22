new WebConnectionWrapper(webClient) {

    public WebResponse getResponse(WebRequest request) throws IOException {
        WebResponse response = super.getResponse(request);

        URL url = request.getUrl();
        int status = response.getStatusCode();
        // store the status

        return response;
    }
};