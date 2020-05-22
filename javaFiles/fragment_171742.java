public Object doSomething(Object id) {
    try(CloseableHttpClient client = HttpClients.createDefault()){
        ObjectMapper objectMapper = new ObjectMapper();
        String bodyRequest = objectMapper.writeValueAsString(id);
        StringEntity entity = new StringEntity(bodyRequest, ContentType.APPLICATION_JSON);
        HttpPut request = new HttpPut(url);
        request.setEntity(entity);

        try(CloseableHttpResponse response = client.execute(request)){
            int statusCode = response.getStatusLine().getStatusCode();

            if(statusCode != HttpStatus.SC_OK){
                System.err.println(statusCode + ": " + response.getStatusLine().getReasonPhrase());
            }
        }
    }
    catch(Exception e){
        throw new RuntimeException(e);
    }
}