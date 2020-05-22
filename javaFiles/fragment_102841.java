@Test
public void wireMockTest() throws IOException{

    String route = "/test";
    String body = "Hello World!";

    //Build the mock server
    WireMockServer server = new WireMockServer(Options.DYNAMIC_PORT);     
    server.start();

    //Configure okHttp
    OkHttpClient client = new OkHttpClient.Builder().build();
    String mockServerURL = "http://localhost:" + server.port();

    //Add the route to the server using JSON
    okhttp3.Request configRequest = new okhttp3.Request.Builder().url(mockServerURL + "/__admin/mappings")
            .post(RequestBody.create(MediaType.parse("application/json"), 
                "{\n" +
                "    \"request\": {\n" +
                "        \"method\": \"GET\",\n" +
                "        \"url\": \"" +route + "\"" +
                "    },\n" +
                "    \"response\": {\n" +
                "        \"status\": \"200\",\n" +
                "        \"body\": \""+body+"\",\n" +
                "        \"headers\": {\n" +
                "            \"Content-Type\": \"text/plain\",\n" +
                "            \"Content-Length\": \""+body.length()+"\"\n" +
                "        }\n" +
                "    }\n" +
                "}")).build();
    client.newCall(configRequest).execute();

    //Hit the server with okHttp
    okhttp3.Request serverRequest = new okhttp3.Request.Builder().url(mockServerURL + route).build();
    Response resposne = client.newCall(serverRequest).execute();

    //Verify the content length is not set
    Assert.assertEquals("The content length was no read correctly", body.length(), resposne.body().contentLength());
}