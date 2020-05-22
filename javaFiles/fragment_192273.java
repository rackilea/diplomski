@BeforeAll
public void init() {
    RestAssured.baseURI = "https://my-aws-api.com";
    RestAssured.filters((requestSpec, responseSpec, ctx) -> {
        Map<String, String> headers = requestSpec.getHeaders()
                .asList()
                .stream()
                .collect(Collectors.toMap(Header::getName, Header::getValue));
        Map<String, String> signedHeaders = aws4sign(requestSpec.getURI(), headers);
        requestSpec.removeHeaders();
        requestSpec.headers(signedHeaders);
        return ctx.next(requestSpec, responseSpec);
    });
}