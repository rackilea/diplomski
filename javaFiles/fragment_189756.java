InputStream inSig = PGPUtil.getDecoderStream(new FileInputStream(signaturFile));
    //ArmoredInputStream inSig = new ArmoredInputStream(new FileInputStream(signaturFile));
    JcaPGPObjectFactory objFactory = new JcaPGPObjectFactory(inSig);
    PGPSignatureList signatureList = (PGPSignatureList) objFactory.nextObject();
    PGPSignature signature = signatureList.get(0);

    InputStream keyIn = PGPUtil.getDecoderStream(new FileInputStream(publicKeyFile));
    //ArmoredInputStream keyIn = new ArmoredInputStream(new FileInputStream(publicKeyFile));
    JcaPGPPublicKeyRingCollection pgpRing = new JcaPGPPublicKeyRingCollection(keyIn);
    PGPPublicKey publicKey = pgpRing.getPublicKey(signature.getKeyID());

    byte[] bytePublicKeyFingerprint = publicKey.getFingerprint();
    char[] publicKeyFingerprintHexArray = org.apache.commons.codec.binary.Hex.encodeHex(bytePublicKeyFingerprint);
    String publicKeyFingerprintHex = new String(publicKeyFingerprintHexArray);

    signature.init(new JcaPGPContentVerifierBuilderProvider().setProvider("BC"), publicKey);

    FileInputStream in = new FileInputStream(file);
    byte[] byteData = new byte[(int) file.length()];
    in.read(byteData);
    in.close();
    signature.update(byteData);

    if (signature.verify() && publicKeyFingerprintHex.equals(fingerprint)) {
        return true;
    } else {
        return false;
    }