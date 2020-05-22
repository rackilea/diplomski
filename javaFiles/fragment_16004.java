@Test
public void exampleTest() throws Exception {

    stubFor(get(urlEqualTo("/login")).withHeader("Accept", equalTo("application/json"))
            .willReturn(aResponse().withStatus(200).withBody("Login Success")
                    .withStatusMessage("Everything was just fine!"))
            .willReturn(okJson("{ \"message\": \"Hello\" }")));

    String url = "http://localhost:8080/login";
    HttpClient client = HttpClientBuilder.create().build();
    HttpGet request = new HttpGet(url);
    request.addHeader("Content-Type", "application/json");
    request.addHeader("Accept", "application/json");
    HttpResponse response = client.execute(request);

    verify(getRequestedFor(urlPathEqualTo("/login"))
            .withHeader("Content-Type", equalTo("application/json")));
}