KeyStore keyStore = null;
    try {
        keyStore = KeyStore.getInstance("BKS", BouncyCastleProvider.PROVIDER_NAME); //you can use JKS if that is what you have
        InputStream inputStream = new File("pathtoyourkeystore");
        try {
            keyStore.load(inputStream, "password".toCharArray());
        } finally {
            inputStream.close();
        }
    } catch(Exception e) {
        System.out.println("Loading keystore failed.");
        e.printStackTrace();
    }
    return keyStore;
}