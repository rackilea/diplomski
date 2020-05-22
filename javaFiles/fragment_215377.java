InputStream inStream = new FileInputStream("1_public.pem");
        BufferedInputStream bis = new BufferedInputStream( inStream );

        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        List<Certificate> certList = new ArrayList<Certificate>();
        Certificate certificate = cf.generateCertificate(bis);
        certList.add(certificate);
        Store certs = new JcaCertStore(certList);
        CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
        gen.addCertificates( certs );

        final byte[] signedHash = "signedhash".getBytes();

        ContentSigner nonSigner = new ContentSigner() {

            @Override
            public byte[] getSignature() {
                return signedHash;
            }

            @Override
            public OutputStream getOutputStream() {
                return new ByteArrayOutputStream();
            }

            @Override
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return new DefaultSignatureAlgorithmIdentifierFinder().find( "SHA256WithRSA" );
            }
        };

        org.bouncycastle.asn1.x509.Certificate cert = org.bouncycastle.asn1.x509.Certificate.getInstance(ASN1Primitive.fromByteArray(certificate.getEncoded()));
        JcaSignerInfoGeneratorBuilder sigb = new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().build());
        sigb.setDirectSignature( true );
        gen.addSignerInfoGenerator(sigb.build(nonSigner, new X509CertificateHolder(cert)));
        CMSProcessableInputStream msg = new CMSProcessableInputStream( new ByteArrayInputStream( "not used".getBytes() ) );

        CMSSignedData signedData = gen.generate(msg, false);
        byte[] pkcs7 = signedData.getEncoded();