// Scopes for the OAuth token
private static final Set<String> SCOPES =
        ImmutableSet.of("https://www.googleapis.com/auth/cloud-platform");

public static Credential getUserCredential() throws Exception {
    GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
            JSON_FACTORY,
            new InputStreamReader(SecurityUtilities.class.
                    getResourceAsStream("/client_secret.json")));
    dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);

// set up authorization code flow.
    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
            HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
            .setDataStoreFactory(dataStoreFactory)
            .build();
    // authorize and get credentials.
    return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
            .authorize("<Personal user account>");