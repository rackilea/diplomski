@Test
public void test() {
    String uri = ServletUriComponentsBuilder.fromRequest(request).replacePath("relativePath").replaceQuery(null).build().toUriString();
    assertThat(uri, is("https://84.198.58.199:8080/relativePath"));

}