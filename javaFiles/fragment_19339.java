/* Construct signed attributes */
    ASN1EncodableVector signedAttributes = new ASN1EncodableVector();
    signedAttributes.add(new Attribute(CMSAttributes.contentType, new DERSet(new ASN1ObjectIdentifier("1.2.840.113549.1.7.1"))));
    signedAttributes.add(new Attribute(CMSAttributes.messageDigest, new DERSet(new DEROctetString(digestBytes))));
    signedAttributes.add(new Attribute(CMSAttributes.signingTime, new DERSet(new DERUTCTime(signingDate))));

    AttributeTable signedAttributesTable = new AttributeTable(signedAttributes);
    signedAttributesTable.toASN1EncodableVector();
    DefaultSignedAttributeTableGenerator signedAttributeGenerator = new DefaultSignedAttributeTableGenerator(signedAttributesTable);

    /* Build the SignerInfo generator builder, that will build the generator... that will generate the SignerInformation... */
    SignerInfoGeneratorBuilder signerInfoBuilder = new SignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider("BC").build());
    signerInfoBuilder.setSignedAttributeGenerator(signedAttributeGenerator);
    CMSSignedDataGenerator generator = new CMSSignedDataGenerator();
    JcaContentSignerBuilder contentSigner = new JcaContentSignerBuilder("SHA1withRSA");
    contentSigner.setProvider("BC");

    generator.addSignerInfoGenerator(signerInfoBuilder.build(contentSigner.build(this.signingKey), new X509CertificateHolder(this.signingCert.getEncoded())));

    ArrayList<X509CertificateHolder> signingChainHolder = new ArrayList<X509CertificateHolder>();
    Iterator i = this.signingChain.iterator();
    while (i.hasNext()) {
        X509CertificateObject cert = (X509CertificateObject)i.next();
        signingChainHolder.add(new X509CertificateHolder(cert.getEncoded()));
    }

    generator.addCertificates(new JcaCertStore(signingChainHolder));
    generator.generate(new CMSAbsentContent(), "BC").getEncoded();