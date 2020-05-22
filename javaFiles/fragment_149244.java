@Component
public class KeystoreInit {

    private final Environment environment;

    @Autowired
    public KeystoreInit(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ServerProperties serverProperties() {
        final ServerProperties serverProperties = new ServerProperties();
        final Ssl ssl = new Ssl();
        final String keystorePassword = getKeystorePassword();
        ssl.setKeyPassword(keystorePassword);
        System.setProperty("server.ssl.key-store-password", keystorePassword);
        serverProperties.setSsl(ssl);
        return serverProperties;
    }

    private String getKeystorePassword() {
        // ...
    }

}