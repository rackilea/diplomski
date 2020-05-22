public class DropboxFileSystemTest {

    // credentials
    private static final String APP_KEY = ""; // TODO : paste your app key
    private static final String APP_SECRET = ""; // TODO : paste your app secret

    // do run the test and follow the instructions
    private static final String accountEmail = "test@domain.com"; // TODO : paste your test Dropbox account
    private static String authCode; // TODO : run the test and paste auth code
    private static String accessToken // TODO : run the test and paste access

    private DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

    // Run through Dropbox API authorization process
    private DbxRequestConfig requestConfig = new DbxRequestConfig(DropboxFileSystemTest.class.getSimpleName());
    private DbxWebAuth webAuth = new DbxWebAuth(requestConfig, appInfo);

    private void startAuth() throws IOException {
        DbxWebAuth.Request webAuthRequest = DbxWebAuth.newRequestBuilder()
            .withNoRedirect()
            .build();

        String authorizeUrl = webAuth.authorize(webAuthRequest);
        System.out.println("1. Go to " + authorizeUrl);
        System.out.println("2. Click \"Allow\" (you might have to log in first). WARNING: log-in to " + accountEmail);
        System.out.println("3. Copy the authorization code.");
        System.out.println("4. Paste the authorization code to this test `this.authCode` value");
        System.out.println("5. Re-run the test");
    }

    private DbxClientV2 client; // to be used for the requests

    private void initWithAccessToken() {
        DbxRequestConfig config = new DbxRequestConfig(UUID.randomUUID().toString());
        client = new DbxClientV2(config, accessToken);
    }

    private void initAndVerifyAccount() throws DbxException {
        initWithAccessToken();

        // check expected account (trying to prevent user account to be wiped out)
        DbxClientV2 client = DbxClientHolder.get().getClient();
        FullAccount account = client.users().getCurrentAccount();
        if (!account.getEmail().equals(accountEmail))
            throw new RuntimeException("Wrong account: current is " + account.getEmail() + ", but " + accountEmail + " is expected");
    }

    private void clearFileSystem() throws FileSystemException {
        // TODO : clear Dropbox file system
    }

    @Before
    public void setUp() throws IOException, FileSystemException, DbxException {
        auth();
        clearFileSystem();
    }

    private void finishAuth() {
        DbxAuthFinish authFinish;
        try {
            authFinish = webAuth.finishFromCode(authCode);
        } catch (DbxException ex) {
            System.err.println("Error in DbxWebAuth.authorize: " + ex.getMessage());
            System.exit(1); return;
        }

        System.out.println("Authorization complete.");
        System.out.println("- User ID: " + authFinish.getUserId());
        System.out.println("- Access Token: " + authFinish.getAccessToken());
        System.out.println();

        System.out.println("1. Copy the access token");
        System.out.println("2. Paste the access token to this test `this.accessToken` value");
        System.out.println("3. Re-run the test");

        accessToken = authFinish.getAccessToken();
    }

    private void auth() throws IOException, FileSystemException, DbxException {
        if (accessToken == null) {
            if (authCode != null ) {
                finishAuth();
                throw new RuntimeException("Manual actions required: copy-paste access token");
            } else {
                startAuth();
                throw new RuntimeException("Manual actions required: copy-paste authCode");
            }
        } else {
            initAndVerifyAccount();
        }
    }

    @After
    public void tearDown() throws FileSystemException {
        if (client != null) {
            clearFileSystem();
        }
    }

    @Test
    public void testSmth() {
        // TODO : write your test using `this.client` for requests
    }