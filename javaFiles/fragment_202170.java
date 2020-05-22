/** The fingerprint calculator to use whenever it is needed. */ 
  static final KeyFingerPrintCalculator FP_CALC = new BcKeyFingerprintCalculator(); 

  // Private class method readPublicKeyFromCol
  private static PGPPublicKey readPublicKeyFromCol(InputStream in)
                 throws Exception {
          PGPPublicKeyRing pkRing = null;
          PGPPublicKeyRingCollection pkCol = new PGPPublicKeyRingCollection(in, FP_CALC);
          System.out.println("key ring size=" + pkCol.size());
          Iterator it = pkCol.getKeyRings();
          while (it.hasNext()) {
                  pkRing = (PGPPublicKeyRing) it.next();
                  Iterator pkIt = pkRing.getPublicKeys();
                  while (pkIt.hasNext()) {
                          PGPPublicKey key = (PGPPublicKey) pkIt.next();
                          System.out.println("Encryption key = " + key.isEncryptionKey() + ", Master key = " + 
                                             key.isMasterKey());
                          if (key.isEncryptionKey())
                                  return key;
                  }
          }
          return null;
  }