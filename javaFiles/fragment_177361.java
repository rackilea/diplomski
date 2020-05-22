private String initiateResumableUpload() throws IOException {
        String URI = "https://storage.googleapis.com/" + bucket + "/" + path;
        GenericUrl url = new GenericUrl(URI);
        HttpRequest req = requestFactory.buildPostRequest(url, new ByteArrayContent("text/plain", new byte[0]));
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-goog-resumable", "start");
        headers.setContentLength((long) 0);
        headers.setContentType("text/plain");
        req.setHeaders(headers);
        req.setReadTimeout((int) DEFAULT_TIMEOUT);
        req.setResponseHeaders(headers);
        HttpResponse resp;
        try {
            resp = req.execute();
        } catch (IOException e) {
            throw e;
        }
        if (resp.getStatusCode() == 201) {
            String location = resp.getHeaders().getLocation();
            return location;

        } else {
            throw new IOException();
        }
    }