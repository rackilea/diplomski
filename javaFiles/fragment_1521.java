public static X509Certificate sign(PKCS10CertificationRequest inputCSR, PrivateKey caPrivate, KeyPair pair)
        throws InvalidKeyException, NoSuchAlgorithmException,
        NoSuchProviderException, SignatureException, IOException,
        OperatorCreationException, CertificateException {   

    AlgorithmIdentifier sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder()
            .find("SHA1withRSA");
    AlgorithmIdentifier digAlgId = new DefaultDigestAlgorithmIdentifierFinder()
            .find(sigAlgId);

    AsymmetricKeyParameter foo = PrivateKeyFactory.createKey(caPrivate
            .getEncoded());
    SubjectPublicKeyInfo keyInfo = SubjectPublicKeyInfo.getInstance(pair
            .getPublic().getEncoded());

    PKCS10CertificationRequestHolder pk10Holder = new PKCS10CertificationRequestHolder(inputCSR);
    //in newer version of BC such as 1.51, this is 
    //PKCS10CertificationRequest pk10Holder = new PKCS10CertificationRequest(inputCSR);

    X509v3CertificateBuilder myCertificateGenerator = new X509v3CertificateBuilder(
            new X500Name("CN=issuer"), new BigInteger("1"), new Date(
                    System.currentTimeMillis()), new Date(
                    System.currentTimeMillis() + 30 * 365 * 24 * 60 * 60
                            * 1000), pk10Holder.getSubject(), keyInfo);

    ContentSigner sigGen = new BcRSAContentSignerBuilder(sigAlgId, digAlgId)
            .build(foo);        

    X509CertificateHolder holder = myCertificateGenerator.build(sigGen);
    X509CertificateStructure eeX509CertificateStructure = holder.toASN1Structure(); 
    //in newer version of BC such as 1.51, this is 
    //org.spongycastle.asn1.x509.Certificate eeX509CertificateStructure = holder.toASN1Structure(); 

    CertificateFactory cf = CertificateFactory.getInstance("X.509", "BC");

    // Read Certificate
    InputStream is1 = new ByteArrayInputStream(eeX509CertificateStructure.getEncoded());
    X509Certificate theCert = (X509Certificate) cf.generateCertificate(is1);
    is1.close();
    return theCert;
    //return null;
}