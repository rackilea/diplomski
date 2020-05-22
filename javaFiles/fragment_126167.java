public boolean check(X509Certificate issuer, X509Certificate uploaded) {
  Principal subjectDN = issuer.getSubjectDN();
  Principal issuerDN = uploaded.getIssuerDN();
  if (!subjectDN.equals(issuerDN)) {
      return false;
  }
  PublicKey pubKey = issuer.getPublicKey();
  try {
      uploaded.verify(pubKey);
  } catch (Exception e) {
      return false;
  }
  return true;
}