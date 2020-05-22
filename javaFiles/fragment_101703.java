public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
public static final JsonFactory JSON_FACTORY = new JacksonFactory();
private static final String CREDENTIALS_DIRECTORY = ".oauth-credentials";

public static Credential authorize(List<String> scopes, String credentialDatastore) throws IOException {
    Reader clientSecretReader = new InputStreamReader(
            new FileInputStream("/client_secrets.json"));
    GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, clientSecretReader);
    System.out.println(clientSecretReader.toString());
    if (clientSecrets.getDetails().getClientId().startsWith("Enter")
            || clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
        System.out.println(
                "Enter Client ID and Secret from https://console.developers.google.com/project/_/apiui/credential "
                        + "into src/main/resources/client_secrets.json");
        return null;
    }
    FileDataStoreFactory fileDataStoreFactory = new FileDataStoreFactory(new File(System.getProperty("user.home") + "/" + CREDENTIALS_DIRECTORY));
    DataStore<StoredCredential> datastore = fileDataStoreFactory.getDataStore(credentialDatastore);

    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
            HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, scopes).setCredentialDataStore(datastore)
            .build();
    LocalServerReceiver localReceiver = new LocalServerReceiver.Builder().setPort(8081).build();

    return new AuthorizationCodeInstalledApp(flow, localReceiver).authorize("user");
}

private static int counter = 0;
private static YouTube youtube;

public static void getYoutubeOauth() throws Exception {
    List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.force-ssl");
    Credential credential = authorize(scopes, "commentthreads");
    youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential).build();

    String videoId = "KIgxmV9xXBQ";

    // Get video comments threads
    CommentThreadListResponse commentsPage = prepareListRequest(videoId).execute();

    while (true) {
        handleCommentsThreads(commentsPage.getItems());

        String nextPageToken = commentsPage.getNextPageToken();
        if (nextPageToken == null)
            break;

        commentsPage = prepareListRequest(videoId).setPageToken(nextPageToken).execute();
    }

    System.out.println("Total: " + counter);
}

private static YouTube.CommentThreads.List prepareListRequest(String videoId) throws Exception {

    return youtube.commentThreads()
                  .list("snippet,replies")
                  .setVideoId(videoId)
                  .setMaxResults(100L)
                  .setModerationStatus("published")
                  .setTextFormat("plainText");
}

private static void handleCommentsThreads(List<CommentThread> commentThreads) {

    for (CommentThread commentThread : commentThreads) {
        List<Comment> comments = Lists.newArrayList();
        comments.add(commentThread.getSnippet().getTopLevelComment());

        CommentThreadReplies replies = commentThread.getReplies();
        if (replies != null)
            comments.addAll(replies.getComments());

        System.out.println("Found " + comments.size() + " comments.");

        // Do your comments logic here
        counter += comments.size();
    }
}