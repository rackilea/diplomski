BufferedReader br = null;
    String output;
    StringBuilder responseBuilder = null;
    HttpClient httpClient = HttpClientBuilder.create().build();
    URIBuilder uriBuilder = new URIBuilder(<UPLOAD_URL>);
    HttpPut request = new HttpPut(uriBuilder.build());
    request.addHeader("Authorization", "Bearer " + oneDriveConnection.getAccessToken());
    request.addHeader("Content-Type", mimeType);
    HttpEntity entity = new ByteArrayEntity(bytes);
    request.setEntity(entity);
    HttpResponse response = httpClient.execute(request);
    int responseCode = response.getStatusLine().getStatusCode();
    if (responseCode == 201 || responseCode == 200) {
        br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        responseBuilder = new StringBuilder();
        while ((output = br.readLine()) != null) {
            responseBuilder.append(output);
        }
    } else {
        logger.error("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        throw new UploadException("Upload failure, Status code : " + response.getStatusLine().getStatusCode());
    }