@Test
public void postUsesRestTemplate() throws IOException, URISyntaxException {
    Path resource = Paths.get(getClass().getClassLoader().getResource("expected-foo.json").toURI());
    String expectedJson = Files.lines(resource).collect(Collectors.joining());
    server.expect(once(), requestTo("http://example.org/api/foo"))
        .andExpect(method(HttpMethod.POST))
        .andExpect(MockRestRequestMatchers.content().json(expectedJson))
        .andRespond(withSuccess());
    // Invoke your service here
    fooService.post();
    server.verify();
}