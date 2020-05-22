public PublicKey publicKeyParse(byte[] publicKeyBytes) {
            InputStream pgpIn = PGPUtil.getDecoderStream(new ByteArrayInputStream(publicKeyBytes));
            PGPObjectFactory pgpFact = new PGPObjectFactory(pgpIn, new JcaKeyFingerprintCalculator());
            PGPPublicKeyRing pgpSecRing = (PGPPublicKeyRing) pgpFact.nextObject();
            PGPPublicKey publicKey = pgpSecRing.getPublicKey();
            JcaPGPKeyConverter converter = new JcaPGPKeyConverter();
            Provider bcProvider = new BouncyCastleProvider();
            converter.setProvider(bcProvider);
            return converter.getPublicKey(publicKey);
    }