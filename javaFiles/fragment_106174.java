private void checkRevocation(final List<X509Certificate> certificates, final CertStore revocationLists, final Set<TrustAnchor> trustAnchors) throws GeneralSecurityException {
    final Map<String, PublicKey> publicKeyMap = extractPublicKeys(certificates, trustAnchors);

    //check the whole chain, we don't know if the issuer or the signer was revoked
    for(final X509Certificate certificate : certificates){
        final X500Principal issuerX500Principal = certificate.getIssuerX500Principal();

        //get the issuer of this certificate
        final PublicKey issuerPublicKey = publicKeyMap.get(issuerX500Principal.getName());

        if(issuerPublicKey == null){
            throw new GeneralSecurityException("Unable to find issuer for certificate '" + certificate.getSubjectX500Principal() + "'");
        }

        final X509CRLSelector crlSelector = new X509CRLSelector();
        //we only use the issuer, not the date or time, don't want CRLs to expire
        crlSelector.addIssuer(issuerX500Principal);

        //get all CRLs that match this issuer
        final Collection<? extends CRL> selectedCRLs = revocationLists.getCRLs(crlSelector);
        for(final CRL crl : selectedCRLs){
            final X509CRL x509CRL = (X509CRL)crl;
            //check first if the crl is really published by the issuer
            x509CRL.verify(issuerPublicKey);

            //check if the current certificate was revoked
            final X509CRLEntry revokedCertificate = x509CRL.getRevokedCertificate(certificate);

            //if we found a revoked certificate throw an exception
            if(revokedCertificate != null){
                throw new GeneralSecurityException(String.format("Unable to use certificate '%1$s', revocation after %2$tF %2$tT, reason: %3$s",
                        certificate.getSubjectX500Principal(), revokedCertificate.getRevocationDate(), revokedCertificate.getRevocationReason()));
            }
        }
    }
}

private Map<String, PublicKey> extractPublicKeys(final List<X509Certificate> certificates, final Set<TrustAnchor> trustAnchors) {
    final Map<String, PublicKey> certificateMap = new HashMap<>();
    for(final X509Certificate certificate : certificates){
        certificateMap.put(certificate.getSubjectX500Principal().getName(), certificate.getPublicKey());
    }

    for(final TrustAnchor trustAnchor : trustAnchors){
        final X509Certificate certificate = trustAnchor.getTrustedCert();
        certificateMap.put(certificate.getSubjectX500Principal().getName(), certificate.getPublicKey());
    }
    return certificateMap;
}