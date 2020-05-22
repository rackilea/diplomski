if( environment == 'production') {
    System.setProperty("javax.net.ssl.keyStore",                    '/etc/certificates/prod/keystore.ks');
    System.setProperty("javax.net.ssl.keyStorePassword",            'password');
    System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
} else {
    System.setProperty("javax.net.ssl.keyStore",                    '/etc/certificates/test/keystore.ks');
    System.setProperty("javax.net.ssl.keyStorePassword",            'password');
    System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
}