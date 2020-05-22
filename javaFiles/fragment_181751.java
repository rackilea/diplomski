KeyStore ks = KeyStore.getInstance("JKS");
    InputStream ksIs = new FileInputStream("...");
    try {
        ks.load(ksIs, "password".toCharArray());
    } finally {
        if (ksIs != null) {
            ksIs.close();
        }
    }

    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory
            .getDefaultAlgorithm());
    kmf.init(ks, "keypassword".toCharArray());