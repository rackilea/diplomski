public boolean addVerification(PdfName signatureHash, Collection<byte[]> ocsps, Collection<byte[]> crls, Collection<byte[]> certs) throws IOException, GeneralSecurityException {
    if (used)
        throw new IllegalStateException(MessageLocalization.getComposedMessage("verification.already.output"));
    ValidationData vd = new ValidationData();
    if (ocsps != null) {
        for (byte[] ocsp : ocsps) {
            vd.ocsps.add(buildOCSPResponse(ocsp));
        }
    }
    if (crls != null) {
        for (byte[] crl : crls) {
            vd.crls.add(crl);
        }
    }
    if (certs != null) {
        for (byte[] cert : certs) {
            vd.certs.add(cert);
        }
    }
    validated.put(signatureHash, vd);
    return true;
}