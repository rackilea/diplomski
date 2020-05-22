// Raw value to place in cert for OID 1.2.3.4.
  byte[] bytearray = {0, 0, 0, 0, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};

  // Start creating the certificate beginning with the TBS certificate.      
  V3TBSCertificateGenerator tbsGen = new V3TBSCertificateGenerator();
  tbsGen.setSerialNumber(new ASN1Integer(serialNum));
  tbsGen.setIssuer(issuer);
  tbsGen.setStartDate(new Time(new Date(startDate)));
  tbsGen.setEndDate(new Time(new Date(endDate)));
  tbsGen.setSubject(new X500Name(dn));
  tbsGen.setSubjectPublicKeyInfo(SubjectPublicKeyInfo.getInstance(certPubKey.getEncoded()));
  tbsGen.setSignature(sigGen.getAlgorithmIdentifier());

  // The Key Usage extension:
  X509KeyUsage keyuse = new X509KeyUsage(
     X509KeyUsage.digitalSignature |
     X509KeyUsage.nonRepudiation   |
     X509KeyUsage.keyEncipherment  |
     X509KeyUsage.dataEncipherment);    
  Extension keyUsageExt =
     new Extension(
        Extension.keyUsage,
        true,
        keyuse.getEncoded());

  // The Basic Constraints extension:
  BasicConstraints basic = new BasicConstraints(false);
  Extension basicExt =
     new Extension(
        Extension.basicConstraints,
        false,
        basic.getEncoded());

  // The Custom extension:    
  ASN1ObjectIdentifier asn1iod =
     new ASN1ObjectIdentifier("1.2.3.4");      
  Extension customExt =
     new Extension(
        asn1iod,
        false, 
        bytearray);

  Extension[] extArray = {keyUsageExt, basicExt, customExt};
  tbsGen.setExtensions(new Extensions(extArray));

  // Create the TBS certificate.
  TBSCertificate tbsCert = tbsGen.generateTBSCertificate();

  // Sign the certificate.
  OutputStream ostream       = sigGen.getOutputStream();
  DEROutputStream derOstream = new DEROutputStream(ostream);
  derOstream.writeObject(tbsCert);
  ostream.close();      
  byte[] tbsSig = sigGen.getSignature();

  // Assemble the full X509 certificate. (TBS + Sig Alg + Sig)
  ASN1EncodableVector asnVector = new ASN1EncodableVector();
  asnVector.add(tbsCert);
  asnVector.add(sigGen.getAlgorithmIdentifier());
  asnVector.add(new DERBitString(tbsSig));
  X509CertificateHolder certHolder =
     new X509CertificateHolder(
        org.bouncycastle.asn1.x509.Certificate.getInstance(new DERSequence(asnVector)));

  X509Certificate cert =
     new JcaX509CertificateConverter()
        .setProvider(BC).getCertificate(certHolder);