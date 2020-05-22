public class OAuth2Authenticator {
private static final Logger logger = Logger
        .getLogger(OAuth2Authenticator.class.getName());
private static Session mSession;

public static final class OAuth2Provider extends Provider {
    private static final long serialVersionUID = 1L;

    public OAuth2Provider() {
        super("Google OAuth2 Provider", 1.0,
                "Provides the XOAUTH2 SASL Mechanism");
        put("SaslClientFactory.XOAUTH2",
                "com.example.testjavamail.OAuth2SaslClientFactory");
    }
}

public static void initialize() {
    Security.addProvider(new OAuth2Provider());
}

public static IMAPStore connectToImap(String host, int port,
        String userEmail, String oauthToken, boolean debug)
        throws Exception {
    Properties props = new Properties();
    props.put("mail.imaps.sasl.enable", "true");
    props.put("mail.imaps.sasl.mechanisms", "XOAUTH2");
    props.put(OAuth2SaslClientFactory.OAUTH_TOKEN_PROP, oauthToken);
    Session session = Session.getInstance(props);
    session.setDebug(debug);

    final URLName unusedUrlName = null;
    IMAPSSLStore store = new IMAPSSLStore(session, unusedUrlName);
    final String emptyPassword = "";
    store.connect(host, port, userEmail, emptyPassword);
    return store;
}

public static SMTPTransport connectToSmtp(String host, int port,
        String userEmail, String oauthToken, boolean debug)
        throws Exception {
    Properties props = new Properties();
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.starttls.required", "true");
    props.put("mail.smtp.sasl.enable", "true");
    props.put("mail.smtp.sasl.mechanisms", "XOAUTH2");
    props.put(OAuth2SaslClientFactory.OAUTH_TOKEN_PROP, oauthToken);
    mSession = Session.getInstance(props);
    mSession.setDebug(debug);

    final URLName unusedUrlName = null;
    SMTPTransport transport = new SMTPTransport(mSession, unusedUrlName);
    // If the password is non-null, SMTP tries to do AUTH LOGIN.
    final String emptyPassword = null;
    transport.connect(host, port, userEmail, emptyPassword);

    return transport;
}

public synchronized void testImap(String user, String oauthToken) {
    try {

        initialize();


        IMAPStore imapStore = connectToImap("imap.gmail.com", 993, user,
                oauthToken, true);

    } catch (Exception e) {
        Log.d("test", e.toString());
    }

}

public class ByteArrayDataSource implements DataSource {
    private byte[] data;
    private String type;

    public ByteArrayDataSource(byte[] data, String type) {
        super();
        this.data = data;
        this.type = type;
    }

    public ByteArrayDataSource(byte[] data) {
        super();
        this.data = data;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentType() {
        if (type == null)
            return "application/octet-stream";
        else
            return type;
    }

    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(data);
    }

    public String getName() {
        return "ByteArrayDataSource";
    }

    public OutputStream getOutputStream() throws IOException {
        throw new IOException("Not Supported");
    }
}