@Test
public void testPostWithFileSuccess() throws Exception
{
    FileDataBodyPart filePart = new FileDataBodyPart("file", new File(Resources.getResource("resources/testImage.jpg").toURI()));
    filePart.setContentDisposition(FormDataContentDisposition.name("file").fileName("testImage.jpg").build());

    FormDataMultiPart request = new FormDataMultiPart();
    request.field("data", fixture("resources/postWithFileSuccess.json"), MediaType.APPLICATION_JSON_TYPE);
    request.bodyPart(filePart);

    WebTarget target = mClient.target("http://localhost:8080/crackers").register(MultiPartFeature.class);
    Response response = target
            .request()
            .post(Entity.entity(request, MediaType.MULTIPART_FORM_DATA));

    assertThat(response.getStatus()).isEqualTo(200);
}