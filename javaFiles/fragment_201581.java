// systems I trust
System.setProperty("javax.net.ssl.trustStore", "foo");
System.setProperty("javax.net.ssl.trustStorePassword", "changeit");

// my credentials
System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
System.setProperty("javax.net.ssl.keyStore", "cert.p12");
System.setProperty("javax.net.ssl.keyStorePassword", "changeit");