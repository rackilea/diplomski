private void setSystemProps() {

    String keyStoreFileName = "ssl/clientKeyStore.jks";
    String keyStorePath = ClassLoader.getSystemResource(keyStoreFileName).getPath();
    String keyStoreType = "JKS";
    String keyStorePassword = "mypassword";

    String trustStoreFileName = "ssl/clientTruststore.jks";
    String trustStorePath = ClassLoader.getSystemResource(trustStoreFileName).getPath();
    String trustStoreType = "JKS";
    String trustStorePassword = "mypassword";

    Properties systemProps = System.getProperties();
    systemProps.put("javax.net.ssl.keyStore", keyStorePath);
    systemProps.put("javax.net.ssl.keyStorePassword", trustStorePassword);
    systemProps.put("javax.net.ssl.keyStoreType", keyStoreType);

    systemProps.put("javax.net.ssl.trustStore", trustStorePath);
    systemProps.put("javax.net.ssl.trustStoreType", trustStoreType);
    systemProps.put("javax.net.ssl.trustStorePassword", keyStorePassword);
    System.setProperties(systemProps);
  }