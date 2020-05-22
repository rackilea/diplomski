public static void importFeatureFilesToJira(String filePath, String resultTypeUrlValue){
    String jiraUrl = config.getJiraLoginValue();
    log.info(String.format("Starting upload of Cucumber features to XRAY on Jira project: %s\n Using Jira user: %s ", config.getJiraProjectValue(), config.getJiraLoginValue()));
    log.info(String.format("Path to Report: %s", filePath));
    String authentication = config.getJiraLoginValue() + ':' + config.getJiraPassword();
    BASE64Encoder encoder = new BASE64Encoder();
    String encoded = null;
    try {
        encoded = encoder.encode((authentication).getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    Client client = ClientBuilder.newBuilder()
            .register(MultiPartFeature.class).property(HttpHeaders.AUTHORIZATION, encoded).build();

    //Import type is dynamic below
    StringBuffer url = new StringBuffer(resultTypeUrlValue);
    url.append("?projectKey=").append(config.getJiraProjectValue());
    WebTarget webTarget = client.target(url.toString());
    log.info(String.format("URL of the XRAY API: %s", url.toString()));
    MultiPart multiPart = new MultiPart();
    multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
    FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file",
            new File(filePath),
            MediaType.APPLICATION_OCTET_STREAM_TYPE);
    multiPart.bodyPart(fileDataBodyPart);

    Response response = webTarget.request(
            MediaType.MULTIPART_FORM_DATA)
            .accept(MediaType.APPLICATION_JSON).
                    header(HttpHeaders.AUTHORIZATION, "Basic " + encoded).post(
                    Entity.entity(multiPart, multiPart.getMediaType()));
    log.info(response.getStatus() + " "
            + response.getStatusInfo() + " " + response);
    int responseBody = response.getStatus();
    String responseBodySting = response.toString();
    try{
        if(responseBody==200 && responseBodySting.contains("200")){
            log.info("Cucumber features were uploaded successfully");
        }
    }catch (Exception e){
        log.info("There was an error uploading the Cucumber feature file");
    }
    log.info("End of XRAY file upload publication");
}