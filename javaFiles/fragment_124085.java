private static Credential authorize() throws Exception 
   {
   HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
   JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
   List<String> scopes = Arrays.asList(BloggerScopes.BLOGGER);

   // load client secrets
  GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(new FileInputStream(clientId_File)));

  // set up authorization code flow
  GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
     httpTransport, jsonFactory, clientSecrets, scopes).build();

 // authorize
  return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
  }

protected void doTest2() throws Exception 
    {
    // Configure the Installed App OAuth2 flow.
    Credential credential = authorize();

    Blogger blogger = new Blogger.Builder(httpTransport, jsonFactory, credential).setApplicationName(APP_NAME).setHttpRequestInitializer(credential)
            .build();

    // The request action object.
    GetByUrl blogGetByUrlAction = blogger.blogs().getByUrl(BLOG_URL);

    // Configure which blog URL to look up.
    blogGetByUrlAction.setUrl(BLOG_URL);

    // Restrict the result content to just the data we need.
    blogGetByUrlAction.setFields("description,name,posts/totalItems,updated");

    // This step sends the request to the server.
    Blog blog = blogGetByUrlAction.execute();

    // Now we can navigate the response.
    System.out.println("Name: " + blog.getName());
    System.out.println("Description: " + blog.getDescription());
    System.out.println("Post Count: " + blog.getPosts().getTotalItems());
    System.out.println("Last Updated: " + blog.getUpdated());
}