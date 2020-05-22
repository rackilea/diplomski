XStream xstream = new XStream();
    xstream.processAnnotations(ApiResponse.class);
    xstream.processAnnotations(ResultsetLinks.class);
    xstream.processAnnotations(Result.class);

    ApiResponse result = (ApiResponse)xstream.fromXML(resp);