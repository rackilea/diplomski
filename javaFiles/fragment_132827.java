Environment env = new Environment();
env.setInitialContextFactory(Environment.DEFAULT_INITIAL_CONTEXT_FACTORY);
//  env.setSecurityPrincipal("user");
//  env.setSecurityCredentials("pass");
env.setProviderUrl("t3s://localhost:7002");

InputStream key = new PEMInputStream(new FileInputStream(CERT_KEYFILE));
InputStream cert = new PEMInputStream(new FileInputStream(CERT_CERTFILE));
env.setSSLClientCertificate(new InputStream[] {key, cert});
env.setSSLClientKeyPassword(CERT_KEYPASSWORD);