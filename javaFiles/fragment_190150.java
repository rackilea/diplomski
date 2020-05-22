CMSSignedData s = new CMSSignedData(signedBytes);
CertStore certs = s.getCertificatesAndCRLs("Collection", "BC");
SignerInformationStore signers = s.getSignerInfos();
boolean verified = false;

    for (Iterator i = signers.getSigners().iterator(); i.hasNext(); ) {
      SignerInformation signer = (SignerInformation) i.next();
      Collection<? extends Certificate> certCollection = certs.getCertificates(signer.getSID());
      if (!certCollection.isEmpty()) {
        X509Certificate cert = (X509Certificate) certCollection.iterator().next();
        if (signer.verify(cert.getPublicKey(), "BC")) {
          verified = true;
        }
      }
    }
    CMSProcessable signedContent = s.getSignedContent() ;
    byte[] originalContent  = (byte[]) signedContent.getContent();