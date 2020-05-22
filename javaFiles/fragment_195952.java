public static void run(FileDataSource file) throws Exception
{
    HttpClient httpClient = HttpClientBuilder.create().build();

    URI uri = buildUri();

    HttpPost request = new HttpPost(uri);

    request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

    HttpEntity entity = EntityBuilder
        .create()
        .setStream(file.getInputStream())
        .setContentType(ContentType.APPLICATION_OCTET_STREAM)
        .build();

    request.setEntity(entity);

    HttpResponse response = httpClient.execute(request);
    HttpEntity jsonEntity = response.getEntity();

    System.out.println(EntityUtils.toString(jsonEntity));
}