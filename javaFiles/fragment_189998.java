static final String APPLICATION_NAME = "POC";

/**
* Global instance of the JSON factory.
*/
static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

/** Global instance of the HTTP transport. */
static HttpTransport HTTP_TRANSPORT;

public Gmail getGmailService(String accessToken) throws IOException {
    GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
    return new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
}