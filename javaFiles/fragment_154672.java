try {
        kmf = KeyManagerFactory.getInstance( KeyManagerFactory.getDefaultAlgorithm() );
        KeyStore ks = KeyStore.getInstance( "pkcs12" );
        ks.load(new FileInputStream( caminhoCert ), senha.toCharArray() );

        kmf.init( ks, senha.toCharArray() );

    } catch (KeyStoreException e) {
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (CertificateException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (UnrecoverableKeyException e) {
        e.printStackTrace();
    }
    return kmf.getKeyManagers();
}