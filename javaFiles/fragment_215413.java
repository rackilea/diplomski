CMSSignedDataGenerator gen1 = new CMSSignedDataGenerator();
 List<X509Certificate> certificates = new ArrayList<>();

 // I chose to add the CA certificate
 certificates.add((X509Certificate) this.caCertificate);

 // In this case, this is a certificate that I need to add
 if (this.certificate != null)
     certificates.add((X509Certificate) this.certificate);

 // This is the recipient certificate
 if (this.recipientCert != null)
     certificates.add((X509Certificate) this.recipientCert);
 Collection<JcaX509CertificateHolder> x509CertificateHolder = new ArrayList<>();

 // Of course, we need to handle the exceptions...
 for (X509Certificate certificate : certificates) {
     x509CertificateHolder.add(new JcaX509CertificateHolder(certificate));
 }
 CollectionStore<JcaX509CertificateHolder> store = new CollectionStore<>(x509CertificateHolder);

// The final stage.
 gen1.addCertificates(store);