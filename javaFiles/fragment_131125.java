public class HttpClientEncoding {

    static String TINY_UTF8_DOC = "[{ \"id\" : \"2\", \"fields\" : { \"subject\" : " +
            "[{ \"name\" : \"subject\", \"value\" : \"Stra\u00DFe\" }] } }]";

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://httpbin.org/post");
        StringEntity entity = new StringEntity(TINY_UTF8_DOC, ContentType.APPLICATION_JSON);
        //StringEntity entity = new StringEntity(TINY_UTF8_DOC, ContentType.create("application/json; charset=utf-8"));
        post.setEntity(entity);
        HttpResponse response = httpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readValue(result, JsonNode.class);
        System.out.println(node.get("json").get(0).get("fields").get("subject").get(0).get("value").asText());
    }
}