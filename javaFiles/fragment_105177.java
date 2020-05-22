private byte[] encryptCertToPKCS7(X509Certificate certificate, Key key) 
                throws CertificateEncodingException, CMSException, NoSuchProviderException, NoSuchAlgorithmException, IOException, OperatorCreationException {
        CMSSignedDataGenerator generator = new CMSSignedDataGenerator();

        ContentSigner sha256Signer = new JcaContentSignerBuilder("SHA256withRSA").setProvider("BC").build((PrivateKey) key);
        generator.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder()
                                                                               .setProvider("BC").build())
                                                                              .build(sha256Signer, certificate));
        generator.addCertificates(new JcaCertStore(certificates));
        CMSTypedData content = new CMSProcessableByteArray(certificate.getEncoded());

        CMSSignedData signedData = generator.generate(content, true);
        return signedData.getEncoded();
    }