KeyPair pair = generateKeyPair();
PKCS10CertificationRequestBuilder p10Builder = new JcaPKCS10CertificationRequestBuilder(
    new X500Principal("CN=Requested Test Certificate"), pair.getPublic());
JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder("SHA256withRSA");
ContentSigner signer = csBuilder.build(pair.getPrivate());
PKCS10CertificationRequest csr = p10Builder.build(signer);