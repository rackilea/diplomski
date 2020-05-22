String configPath = "C:/eclipse/workspace/uniproject/";
Properties systemProps = System.getProperties();
systemProps.put( "javax.net.ssl.trustStore", configPath+"uni_truststore.jks");
systemProps.put( "javax.net.ssl.keyStore", configPath+"uni_keystore.jks");
System.setProperties(systemProps);

Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
s = (SSLSocket) factory.createSocket(UNI_ADDRESS, UNI_PORT);