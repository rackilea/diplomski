public String updateAttribute(String entity, String id, List<Map<String, Object>> parameters) throws IOException, URISyntaxException {
JSONObject object = new JSONObject();
    for (Map<String, Object> map : parameters) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            object.put(key, value);
        }
    }

    String urlString = "";
    urlString = RESOURCE + "/api/data/"+API_VERSION+"/"+entity+"(" + id + ")/";
    StringEntity stringEntity = new StringEntity(object.toString());

    URL url = new URL(urlString);
    HttpPatch httpPatch = new HttpPatch(urlString);
    httpPatch.addHeader("OData-MaxVersion", "4.0");
    httpPatch.addHeader("OData-Version", "4.0");
    httpPatch.addHeader("Accept", "application/json");
    httpPatch.addHeader("Authorization", "Bearer " + token);
    httpPatch.addHeader("Content-Type", "application/json");
    httpPatch.setEntity(stringEntity);

    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpResponse httpResponse = httpClient.execute(httpPatch);

int responseCode =  httpResponse.getStatusLine().getStatusCode();

if (responseCode > 299) {
    InputStream inputStream = httpResponse.getEntity().getContent();
    ByteArrayOutputStream result = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int length;
    while ((length = inputStream.read(buffer)) != -1) {
        result.write(buffer, 0, length);
    }

    throw new IOException(result.toString("UTF-8"));
}

return responseCode;
}