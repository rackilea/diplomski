SubjectPublicKeyInfo subPubKeyInfo = SubjectPublicKeyInfo.getInstance(pair.getPublic().getEncoded());
X509v1CertificateBuilder builder = new X509v1CertificateBuilder(
       subjectDN, 
       serialNumber, 
       validityStartDate,
       validityEndDate, 
       subjectDN, 
       subPubKeyInfo);

AlgorithmIdentifier sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder().find(signatureAlgorithm); 
AlgorithmIdentifier digAlgId = new DefaultDigestAlgorithmIdentifierFinder().find(sigAlgId); 
ContentSigner contentSigner = 
      new BcRSAContentSignerBuilder(sigAlgId, digAlgId)                   
               .build(PrivateKeyFactory.createKey(pair.getPrivate().getEncoded())); 

X509CertificateHolder holder = builder.build(contentSigner);

X509Certificate cert = JcaX509CertificateConverter().getCertificate(holder);