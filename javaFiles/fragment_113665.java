private static void setupServerKeystore() throws GeneralSecurityException, IOException {
        mServerKeyStore = KeyStore.getInstance( "JKS" );
        mServerKeyStore.load(iComputer.class.getClassLoader().getResourceAsStream("res/server.public"), 
                            "pswd".toCharArray());
    }

private static void setupClientKeyStore() throws GeneralSecurityException, IOException {
        mClientKeyStore = KeyStore.getInstance( "JKS" );
        mClientKeyStore.load(iComputer.class.getClassLoader().getResourceAsStream("res/client.private"),
                               mPassphrase.toCharArray());
}