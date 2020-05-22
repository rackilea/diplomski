@Override
protected KeyManager[] getKeyManagers(KeyStore keyStore) throws Exception {
    return new KeyManager[] {
        new JettyX509ExtendedKeyManager(certificateProviders)
    };
}