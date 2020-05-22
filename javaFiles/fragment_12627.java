PGPSecretKey mySecretKey;
    PGPPublicKey publicKeyToBeSigned; 
    PGPPrivateKey pgpPrivKey = mySecretKey
            .extractPrivateKey(new JcePBESecretKeyDecryptorBuilder()
                    .setProvider("BC").build("password for your private key"));
    PGPSignatureGenerator signatureGenerator = new PGPSignatureGenerator(
            new JcaPGPContentSignerBuilder(mySecretKey.getPublicKey()
                    .getAlgorithm(), PGPUtil.SHA512));
    signatureGenerator.init(PGPSignature.DIRECT_KEY, pgpPrivKey);

    PGPSignature signature = signatureGenerator.generateCertification(
            id, publicKeyToBeSigned);