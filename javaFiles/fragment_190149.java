public byte[] sign(byte[] data) throws 
           GeneralSecurityException, CMSException, IOException {
      Security.addProvider(new BouncyCastleProvider());
      CMSSignedDataGenerator generator = new CMSSignedDataGenerator();
      generator.addSigner(getPrivateKey(), (X509Certificate) getCertificate(),
          CMSSignedDataGenerator.DIGEST_SHA1);
      generator.addCertificatesAndCRLs(getCertStore());
      CMSProcessable content = new CMSProcessableByteArray(data);

      CMSSignedData signedData = generator.generate(content, true, "BC");
      return signedData.getEncoded();
    }

private CertStore getCertStore() throws GeneralSecurityException {
  ArrayList<Certificate> list = new ArrayList<Certificate>();
  Certificate[] certificates = getKeystore().getCertificateChain(this.alias);
  for (int i = 0, length = certificates == null ? 0 : certificates.length; i < length; i++) {
    list.add(certificates[i]);
  }
  return CertStore.getInstance("Collection", new CollectionCertStoreParameters(list), "BC");
}

private PrivateKey getPrivateKey() throws GeneralSecurityException {
  if (this.privateKey == null) {
     this.privateKey = initalizePrivateKey();
  }
  return this.privateKey;
}

private PrivateKey initalizePrivateKey() throws GeneralSecurityException {
   KeyStore keystore = new MyKeystoreProvider().getKeystore();
   return (PrivateKey) keystore.getKey(this.alias, getPasswordAsCharArray());
}