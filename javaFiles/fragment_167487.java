public final class MyRestClient {
    private static Client client = ClientBuilder.newClient();

    public static String hello() {
        String serviceUrl = "http://..../";
        String path ="hello";

        Response response = client
                .target(serviceUrl)
                .path(path)
                .request(ExtendedMediaType.APPLICATION_UTF8)
                .get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            return response.getEntity(String.class);
        }

        throw new WebApplicationException(response);
    }
}