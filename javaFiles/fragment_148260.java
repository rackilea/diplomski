System.setProperty("jsse.enableSNIExtension", "false");

    SslConfigurator sslConfig = SslConfigurator.newInstance()
            .trustStoreFile("C:/Program Files/Java/jre1.8.0_45/lib/security/cacerts.jks")
            .trustStorePassword("somepass")
            .keyStoreFile("C:/Program Files/Java/jre1.8.0_45/lib/security/keystore.jks")
            .keyPassword("somepass");

    SSLContext sslContext = sslConfig.createSSLContext();
    Client client = ClientBuilder.newBuilder().sslContext(sslContext)
            .build();

    HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(
            JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);

    client.register(feature);

    WebTarget webTarget = client.target(JIRA_URL);

    WebTarget projectWebTarget = webTarget.path("project");

    Invocation.Builder invocationBuilder = projectWebTarget
            .request(MediaType.APPLICATION_JSON);

    Response response = invocationBuilder.get();
    System.out.println(response.getStatus());
    System.out.println(response.readEntity(String.class));