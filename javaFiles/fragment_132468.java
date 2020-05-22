String hashAlgorithm = externalSignature.getHashAlgorithm();
PdfPKCS7 sgn = new PdfPKCS7(null, chain, hashAlgorithm, null, externalDigest, false);
InputStream data = sap.getRangeStream();
byte hash[] = DigestAlgorithms.digest(data, externalDigest.getMessageDigest(hashAlgorithm));
Calendar cal = Calendar.getInstance();
byte[] ocsp = null;
if (chain.length >= 2 && ocspClient != null) {
    ocsp = ocspClient.getEncoded((X509Certificate) chain[0], (X509Certificate) chain[1], null);
}
byte[] sh = sgn.getAuthenticatedAttributeBytes(hash, cal, ocsp, crlBytes, sigtype);
byte[] extSignature = externalSignature.sign(sh);
sgn.setExternalDigest(extSignature, null, externalSignature.getEncryptionAlgorithm());