// During initialisation
Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

// During decryption
InputStream is = openKeyring(); // Wherever your keyring is
InputStream isData = openDataFile(); 

try {
  PGPSecretKeyRing kr = new PGPSecretKeyRing();
  PGPSecretKey sk = kr.getSecretKey();
  PGPPrivateKey pl = sk.extractPrivateKey("mypassphrase", securityProvider); 
  PGPObjectFactory of = new PGPObjectFactory(isData);
  Object o;
  while ((o = of.nextObject) != null) {
    if (o instanceof PGPCompressedData) {
      readAndDoWhateverINeedtoDo((PGPCompressedData) o).getDataStream());
    }
  }
}
catch (Exception e) {
  rejectFile(e);
}