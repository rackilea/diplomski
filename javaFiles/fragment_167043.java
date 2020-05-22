private static KeyStore loadTrustStore(String[] certificateFilenames) {
        AssetManager assetsManager = GirdersApp.getInstance().getAssets();

        int length = certificateFilenames.length;
        List<Certificate> certificates = new ArrayList<Certificate>(length);
        for (String certificateFilename : certificateFilenames) {
          InputStream is;
          try {
            is = assetsManager.open(certificateFilename, AssetManager.ACCESS_BUFFER);
            Certificate certificate = KeyStoreManager.loadX509Certificate(is);
            certificates.add(certificate);
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        }

        Certificate[] certificatesArray = certificates.toArray(new Certificate[certificates.size()]);
          return new generateKeystore(certificatesArray);
      }

 /**
   * Generates keystore congaing the specified certificates.
   *
   * @param certificates certificates to add in keystore
   * @return keystore with the specified certificates
   * @throws KeyStoreException if keystore can not be generated.
   */
  public KeyStore generateKeystore(Certificate[] certificates) throws RuntimeException {
      // construct empty keystore
      KeyStore keyStore = KeyStore.getInstance(keyStoreType);

      // initialize keystore
      keyStore.load(null, null);

      // load certificates into keystore
      int length = certificates.length;
      for (int i = 0; i < length; i++) {
        Certificate certificate = certificates[i];
        keyStore.setEntry(String.valueOf(i), new KeyStore.TrustedCertificateEntry(certificate),
            null);
      }
      return keyStore;
  }