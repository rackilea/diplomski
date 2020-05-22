// create and return credential
private static Credential getCredentials() throws IOException {
    GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(PRIVATE_KEY_PATH))
                .createScoped(SCOPES);

    return credential;
}

// build and return an authorized drive client service
public static Drive getDriveService() throws IOException, GeneralSecurityException {
    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

    // Instantiating a client
    Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials())
                .setApplicationName(APPLICATION_NAME)
                .build();

    return service;
}