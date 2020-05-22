Security.addProvider(new BouncyCastleProvider());
File file = new File("test.p12");
char[] password = "test".toCharArray();

KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
keyGen.initialize(2048);
KeyPair keypair = keyGen.genKeyPair();
X500Name issuer = new X500Name("CN=test");
X500Name subject = new X500Name("CN=test");
BigInteger serial = new BigInteger("1");
Date notBefore = new Date();
Date notAfter = new Date(System.currentTimeMillis() + 365 * 24 * 3600000L);
JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(issuer, serial, notBefore, notAfter, subject, keypair.getPublic());
ContentSigner signer = new JcaContentSignerBuilder("SHA256WithRSA").build(keypair.getPrivate());
certBuilder.addExtension(new ASN1ObjectIdentifier("2.5.29.19"), true, new BasicConstraints(true));
X509Certificate cert1 = new JcaX509CertificateConverter().getCertificate(certBuilder.build(signer));

OutputEncryptor pkenc = new JcePKCSPBEOutputEncryptorBuilder(NISTObjectIdentifiers.id_aes256_CBC)
    .setPRF(PBKDF2Config.PRF_SHA256).setIterationCount(100000).setProvider("BC").build(password);

JcaX509ExtensionUtils extUtils = new JcaX509ExtensionUtils();
PKCS12SafeBagBuilder certBagBuilder = new JcaPKCS12SafeBagBuilder(cert1);

certBagBuilder.addBagAttribute(PKCS12SafeBag.friendlyNameAttribute, new DERBMPString("test"));
SubjectKeyIdentifier pubKeyId = extUtils.createSubjectKeyIdentifier(cert1.getPublicKey());
certBagBuilder.addBagAttribute(PKCS12SafeBag.localKeyIdAttribute, pubKeyId);

PKCS12SafeBagBuilder keyBagBuilder = new JcaPKCS12SafeBagBuilder(keypair.getPrivate(), pkenc);

keyBagBuilder.addBagAttribute(PKCS12SafeBag.friendlyNameAttribute, new DERBMPString("test"));
keyBagBuilder.addBagAttribute(PKCS12SafeBag.localKeyIdAttribute, pubKeyId);

PKCS12PfxPduBuilder builder = new PKCS12PfxPduBuilder();

builder.addData(keyBagBuilder.build());

OutputEncryptor crtenc = new JcePKCSPBEOutputEncryptorBuilder(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC)
    .setIterationCount(50000).setProvider("BC").build(password);

builder.addEncryptedData(crtenc, new PKCS12SafeBag[]{certBagBuilder.build()});

PKCS12PfxPdu pfx = builder.build(new JcePKCS12MacCalculatorBuilder(NISTObjectIdentifiers.id_sha256), password);

try (FileOutputStream out = new FileOutputStream(file)) {
    out.write(pfx.getEncoded(ASN1Encoding.DL));
}