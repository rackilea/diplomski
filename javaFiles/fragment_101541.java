class ApiCallerTest {

    private final MockWebServer mockWebServer = new MockWebServer();
    private final ApiCaller apiCaller = new ApiCaller(WebClient.create(mockWebServer.url("/").toString()));

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void call() throws InterruptedException {
        mockWebServer.enqueue(
            new MockResponse()
               .setResponseCode(200)
               .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
               .setBody("{\"y\": \"value for y\", \"z\": 789}")
        );
        SimpleResponseDto response = apiCaller.callApi().block();
        assertThat(response, is(not(nullValue())));
        assertThat(response.getY(), is("value for y"));
        assertThat(response.getZ(), is(789));

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        //use method provided by MockWebServer to assert the request header
        recordedRequest.getHeader("Authorization").equals("customAuth");
        DocumentContext context = JsonPath.parse(recordedRequest.getBody().inputStream());
        //use JsonPath library to assert the request body
        assertThat(context, isJson(allOf(
            withJsonPath("$.a", is("value1")),
            withJsonPath("$.b", is(123))
        )));
    }
}