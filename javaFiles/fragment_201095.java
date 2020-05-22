public static <T> List<T> getList(String url, Class<T> clazz) {

    HttpClient client = HttpClientBuilder.create().build();
    HttpGet getRequest = new HttpGet(url);
    getRequest.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
    getRequest.setHeader(HttpHeaders.COOKIE, Login.getInstance().getToken());

    List<T> data = null;

    HttpResponse response;
    try {
        response = client.execute(getRequest);
        data = Constants.JSON_MAPPER.readValue(response.getEntity().getContent(), Constants.JSON_MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
    } catch (IOException ex) {
        logger.error("Error retrieving  " + clazz.getName() + " " + ex.toString());
    }
    // TODO: Replace List<category> with Observable?
    return data;
}