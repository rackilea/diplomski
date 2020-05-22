public static X509Certificate getCertificte(X500Name subject,
                                          PublicKey subjectPublicKey,
                                          boolean isSubjectCA,
                                          X509Certificate caCertificate,
                                          PrivateKey caPrivateKey,
                                          String signingAlgorithm,
                                          Date validFrom,
                                          Date validTill) throws CertificateEncodingException {

BigInteger sn = new BigInteger(64, random);

X500Name issuerName = new X500Name(caCertificate.getSubjectDN().getName());
SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(subjectPublicKey.getEncoded());

X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(issuerName,
                                                                    sn,
                                                                    validFrom,
                                                                    validTill,
                                                                    subject,
                                                                    subjectPublicKeyInfo);

JcaX509ExtensionUtils extensionUtil;
try {
  extensionUtil = new JcaX509ExtensionUtils();
} catch (NoSuchAlgorithmException e) {
  throw new RuntimeException("No provider found for SHA1 message-digest");
}

// Add extensions
try {
  AuthorityKeyIdentifier authorityKeyIdentifier = extensionUtil.createAuthorityKeyIdentifier(caCertificate);
  certBuilder.addExtension(Extension.authorityKeyIdentifier, false, authorityKeyIdentifier);

  SubjectKeyIdentifier subjectKeyIdentifier = extensionUtil.createSubjectKeyIdentifier(subjectPublicKey);
  certBuilder.addExtension(Extension.subjectKeyIdentifier, false, subjectKeyIdentifier);

  BasicConstraints basicConstraints = new BasicConstraints(isSubjectCA);
  certBuilder.addExtension(Extension.basicConstraints, true, basicConstraints);
} catch (CertIOException e) {
  throw new RuntimeException("Could not add one or more extension(s)");
}

ContentSigner contentSigner;
try {
  contentSigner = new JcaContentSignerBuilder(signingAlgorithm).build(caPrivateKey);
} catch (OperatorCreationException e) {
  throw new RuntimeException("Could not generate certificate signer", e);
}

try {
   return new JcaX509CertificateConverter().getCertificate(certBuilder.build(contentSigner));
 } catch (CertificateException e) {
   throw new RuntimeException("could not generate certificate", e);
 }
}