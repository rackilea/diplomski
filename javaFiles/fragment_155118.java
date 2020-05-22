PGPKeyRingGenerator generator = new PGPKeyRingGenerator(
  PGPSignature.POSITIVE_CERTIFICATION, 
  signKeyPair, john, sha1Calc,
  signhashgen.generate(), null,
  new BcPGPContentSignerBuilder(
    signKeyPair.getPublicKey().getAlgorithm(),
    HashAlgorithmTags.SHA1),
    new BcPBESecretKeyEncryptorBuilder(PGPEncryptedData.AES_256).build(pass)
);    
generator.addSubKey(encKeyPair, enchashgen.generate(), null);    
PGPSecretKeyRing ring = generator.generateSecretKeyRing();