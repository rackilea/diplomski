static {
        System.setProperty("javax.net.ssl.keyStoreType", "pkcs12"); // or whatever
        System.setProperty("javax.net.ssl.keyStore", "c:/folder/mycert.p12");
        System.setProperty("javax.net.ssl.keyStorePassword", "mypassword");
        System.setProperty("javax.net.debug", "ssl");
}