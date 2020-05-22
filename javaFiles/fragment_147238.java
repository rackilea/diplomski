Client client = ClientBuilder.newBuilder()
         .register(MultiPartFeature.class)
         .build();
FormDataMultiPart multiPart = new FormDataMultiPart()
        .field("SourceCredentials[SourceName]", "...")
        .field("ResponseFormat", "JSON")
        .field("...", "...");
Response response = client.target(url)
        .request()
        .header("...", "...")
        .post(Entity.entity(multiPart, multiPart.getMediaType());