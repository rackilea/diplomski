public void signEncryptMessage(InputStream in, OutputStream out, String name) throws IOException, PGPException, SignatureException {
        out = new ArmoredOutputStream(out);

        PGPEncryptedDataGenerator encGen = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(SYMM_ALG).setWithIntegrityPacket(true).setSecureRandom(rand).setProvider(PROVIDER));
        encGen.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(keys.get(name)).setProvider(PROVIDER));

        OutputStream encryptedOut = encGen.open(out, new byte[BUFFER_SIZE]);
        OutputStream compressedData = new PGPCompressedDataGenerator(COMP_ALG).open(encryptedOut);

        PGPSignatureGenerator sGen = new PGPSignatureGenerator(new JcaPGPContentSignerBuilder(kp.getPrivateKey().getPublicKeyPacket().getAlgorithm(), HASH_ALG).setProvider(PROVIDER));
        sGen.init(PGPSignature.BINARY_DOCUMENT, kp.getPrivateKey());
        sGen.generateOnePassVersion(false).encode(compressedData);

        OutputStream finalOut = new PGPLiteralDataGenerator().open(compressedData, PGPLiteralData.BINARY, "", new Date(), new byte[BUFFER_SIZE]);

        byte[] buf = new byte[BUFFER_SIZE];
        int len;
        while ((len = in.read(buf)) > 0) {
            finalOut.write(buf, 0, len);
            sGen.update(buf, 0, len);
        }

        in.close();

        finalOut.close();
        sGen.generate().encode(compressedData);
        compressedData.close();
        encryptedOut.close();
        out.close();
    }