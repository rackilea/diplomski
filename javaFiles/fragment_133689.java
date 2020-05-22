HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

String APPLICATION_NAME = "MyProject";
String SERVICE_ACCOUNT_EMAIL = "my-service-account@developer.gserviceaccount.com";
java.io.File p12File = new java.io.File("MyProject.p12");

GoogleCredential credential = new GoogleCredential.Builder()                                                                    
      .setTransport(httpTransport)                                                     
      .setJsonFactory(jsonFactory)                                                   
      .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)   
      .setServiceAccountScopes(
            Collections.singleton("https://www.google.com/m8/feeds/"))                                                          
      .setServiceAccountPrivateKeyFromP12File(p12File)                                                  
      .setServiceAccountUser("user@example.com")
      .build();

if (!credential.refreshToken()) {
    throw new RuntimeException("Failed OAuth to refresh the token");
}

ContactsService service = new ContactsService(APPLICATION_NAME);
service.setOAuth2Credentials(credential);

Query gQuery = new Query(new java.net.URL("https://www.google.com/m8/feeds/groups/user@example.com/full"));
gQuery.setMaxResults(32767);
ContactGroupFeed groupFeed = service.query(gQuery, ContactGroupFeed.class);

for (ContactGroupEntry group : groupFeed.getEntries()) {
    System.out.println("group: " + group.getTitle().getPlainText());

    Query cQuery = new Query(new java.net.URL("https://www.google.com/m8/feeds/contacts/user@example.com/full"));
    cQuery.setMaxResults(32767);
    String grpId = group.getId();
    cQuery.setStringCustomParameter("group", grpId);
    ContactFeed feed = service.query(cQuery, ContactFeed.class);

    for (ContactEntry contact : feed.getEntries()) {
        System.out.println("name: " + contact.getTitle().getPlainText());
    }
}