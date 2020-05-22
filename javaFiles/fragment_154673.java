private TrustManager[] getTrustManager(String caminhoCacerts){
    TrustManagerFactory tmf = null;
    try {

        tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyStore ts = KeyStore.getInstance("JKS");
        ts.load(new FileInputStream(caminhoCacerts), SENHACACERTS.toCharArray());
        tmf.init(ts);

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
    }
    return tmf.getTrustManagers();
}