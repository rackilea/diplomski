public class HttpClientExample {

    public static void main(String... args) {

        try (var client = HttpClients.createDefault()) {
            var getRequest = new HttpGet("https://jsonplaceholder.typicode.com/todos/1");
            getRequest.addHeader("accept", "application/json");

        HttpResponse response = client.execute(getRequest);
        if (isNot2xx(response.getStatusLine().getStatusCode())) {
            throw new IllegalArgumentException("Failed to get with code: " + response.getStatusLine().getStatusCode());
        }

        Response resp = new ObjectMapper().readValue(EntityUtils.toString(response.getEntity()), Response.class);
        System.out.println(resp.getId());

    } catch (IOException e) {
            e.printStackTrace();
    }

    }

    private static boolean isNot2xx(int statusCode) {
        return statusCode != 200;
    }

}