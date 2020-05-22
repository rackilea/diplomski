// For this example we're saving the credentials in a file on the system,
//  rather than a database.
FileCredentialStore credentialStore = new FileCredentialStore(
    new File(System.getProperty("user.home"), ".credentials/calendar.json"), JSON_FACTORY);

// set up authorization code flow
GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
    HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, Collections.singleton(CalendarScopes.CALENDAR))
    .setCredentialStore(credentialStore)  // This will store the tokens for you
    .build();