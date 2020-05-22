InputStream certIn = ClassLoader.class.getResourceAsStream("/package/myCert.cer");

    final char sep = File.separatorChar;
    File dir = new File(System.getProperty("java.home") + sep + "lib" + sep + "security");
    File file = new File(dir, "cacerts");
    InputStream localCertIn = new FileInputStream(file);

    KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
    keystore.load(localCertIn, passphrase);
    if (keystore.containsAlias("myAlias")) {
        certIn.close();
        localCertIn.close();
        return;
    }
    localCertIn.close();

    BufferedInputStream bis = new BufferedInputStream(certIn);
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    while (bis.available() > 0) {
        Certificate cert = cf.generateCertificate(bis);
        keystore.setCertificateEntry("myAlias", cert);
    }

    certIn.close();

    OutputStream out = new FileOutputStream(file);
    keystore.store(out, passphrase);
    out.close();