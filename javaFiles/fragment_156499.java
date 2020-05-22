TimeStampToken token = new TimeStampToken(new CMSSignedData(response));

InputStream in = new FileInputStream("tsp.cer");
CertificateFactory factory = CertificateFactory.getInstance("X.509");

X509Certificate cert = (X509Certificate) factory.generateCertificate(in);

//RSA Signature processing with BC
X509CertificateHolder holder = new X509CertificateHolder(cert.getEncoded());
SignerInformationVerifier siv = new BcRSASignerInfoVerifierBuilder(new DefaultDigestAlgorithmIdentifierFinder(), new BcDigestCalculatorProvider()).build(holder);

//Signature processing with JCA and other provider
//X509CertificateHolder holderJca = new JcaX509CertificateHolder(cert);
//SignerInformationVerifier sivJca = new JcaSimpleSignerInfoVerifierBuilder().setProvider("anotherprovider").build(holderJca);

token.validate(siv);