final ClientConfig config = new DefaultClientConfig();
final Client client = Client.create(config);

final WebResource resource = client.resource(ENDPOINT_URL);

final MimeMultipart request = new MimeMultipart();
request.addBodyPart(new MimeBodyPart(new FileInputStream(new File(
        fileName))));

final String response = resource
    .entity(request, "multipart/form-data")
    .accept("text/plain")
    .post(String.class);