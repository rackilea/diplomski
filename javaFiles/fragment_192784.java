public void upload(String url, String fileName) {
    InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName);
    FormDataMultiPart part = new FormDataMultiPart().field("file", stream, MediaType.TEXT_PLAIN_TYPE);

    WebResource resource = Client.create().resource(url);
    String response = resource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(String.class, part);
    assertEquals("Hello, World", response);
}