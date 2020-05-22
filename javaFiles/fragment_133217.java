GoogleCredential creds = new GoogleCredential.Builder()
    .setTransport(GoogleNetHttpTransport.newTrustedTransport())
    .setJsonFactory(JacksonFactory.getDefaultInstance())
    .setServiceAccountId(serviceAccountEmailAddress)
    .setServiceAccountPrivateKeyFromP12File(p12FileFromCredentials)
    .setServiceAccountScopes(SCOPES)
    .build();


service.setOAuth2Credentials(creds);