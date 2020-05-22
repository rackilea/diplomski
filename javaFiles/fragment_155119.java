PGPSignatureGenerator generator = new PGPSignatureGenerator(new BcPGPContentSignerBuilder(PGPPublicKey.RSA_GENERAL,
  PGPUtil.SHA1)); 
generator.init(PGPSignature.POSITIVE_CERTIFICATION, johnsPrivateKey);
PGPSignatureSubpacketGenerator signhashgen = copyJohnsSignhashgen();      
generator.setHashedSubpackets(signhashgen.generate());    
PGPSignature certification = generator.generateCertification(jane, getEncryptionKey(secretKeyRing));
PGPPublicKey janesKey = PGPPublicKey.addCertification(getEncryptionKey(secretKeyRing), jane, certification);