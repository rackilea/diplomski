public class OAuth {

    private static final String APPLICATION_NAME = "APPNAME";

    private static final java.io.File DATA_STORE_DIR =
            new java.io.File(System.getProperty("user.home"), "" +
                    "/Store/calendar_sample");

    private static FileDataStoreFactory dataStoreFactory;

    private static HttpTransport httpTransport;

    private static final com.google.api.client.json.JsonFactory JSON_FACTORY = new JacksonFactory();

    private static com.google.api.services.calendar.Calendar client;


    public void authorizeAndTest() {

        try {
            httpTransport = new NetHttpTransport();
            dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
            Credential credential = authorize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Credential authorize() throws Exception {


        FileReader credentialsReader = new FileReader(new File("client_secret_47576556653-go0fkf4c56dohm6m16s2400qed5ps410.apps.googleusercontent.com.json"));

// It gives me an error for line below.
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, credentialsReader);
        if (clientSecrets.getDetails().getClientId().startsWith("Enter")
                || clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
            System.out.println(
                    "Enter Client ID and Secret from https://code.google.com/apis/console/?api=calendar "
                            + "into calendar-cmdline-sample/src/main/resources/client_secrets.json");
            return null;
        }

        AuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets,
                Collections.singleton(CalendarScopes.CALENDAR)).setDataStoreFactory(dataStoreFactory).build();

        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user@gmail.com");
    }