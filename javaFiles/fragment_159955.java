new WebConnectionWrapper(webClient) {

        public WebResponse getResponse(WebRequest request) throws IOException {
            WebResponse response = super.getResponse(request);
            if (request.getUrl().toExternalForm().contains("my_url")) {
                String content = response.getContentAsString("UTF-8");

                //change content

                WebResponseData data = new WebResponseData(content.getBytes("UTF-8"),
                        response.getStatusCode(), response.getStatusMessage(), response.getResponseHeaders());
                response = new WebResponse(data, request, response.getLoadTime());
            }
            return response;
        }
    };