final ClientConfig config = new DefaultClientConfig();
config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
        Boolean.TRUE);
final Client client = Client.create(config);

final WebResource resource = client
        .resource(URL_HERE);
final MimeMultipart response = resource.get(MimeMultipart.class);

// This will iterate the individual parts of the multipart response
for (int i = 0; i < response.getCount(); i++) {
    final BodyPart part = response.getBodyPart(i);
    System.out.printf(
            "Embedded Body Part [Mime Type: %s, Length: %s]\n",
            part.getContentType(), part.getSize());
}