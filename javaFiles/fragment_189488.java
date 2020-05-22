public void makeLtvEnabled(PdfStamper stp, OcspClient ocspClient, CrlClient crlClient) throws IOException, GeneralSecurityException, StreamParsingException, OperatorCreationException, OCSPException {
    stp.getWriter().addDeveloperExtension(new PdfDeveloperExtension(PdfName.ADBE, new PdfName("1.7"), 8));
    LtvVerification v = stp.getLtvVerification();
    AcroFields fields = stp.getAcroFields();

    Map<PdfName, X509Certificate> moreToCheck = new HashMap<>();

    ArrayList<String> names = fields.getSignatureNames();
    for (String name : names)
    {
        PdfPKCS7 pdfPKCS7 = fields.verifySignature(name);
        List<X509Certificate> certificatesToCheck = new ArrayList<>();
        certificatesToCheck.add(pdfPKCS7.getSigningCertificate());
        while (!certificatesToCheck.isEmpty()) {
            X509Certificate certificate = certificatesToCheck.remove(0);
            addLtvForChain(certificate, ocspClient, crlClient,
                    (ocsps, crls, certs) -> {
                        try {
                            v.addVerification(name, ocsps, crls, certs);
                        } catch (IOException | GeneralSecurityException e) {
                            e.printStackTrace();
                        }
                    },
                    moreToCheck::put
            );
        }
    }

    while (!moreToCheck.isEmpty()) {
        PdfName key = moreToCheck.keySet().iterator().next();
        X509Certificate certificate = moreToCheck.remove(key);
        addLtvForChain(certificate, ocspClient, crlClient,
                (ocsps, crls, certs) -> {
                    try {
                        v.addVerification(key, ocsps, crls, certs);
                    } catch (IOException | GeneralSecurityException e) {
                        e.printStackTrace();
                    }
                },
                moreToCheck::put
        );
    }
}

void addLtvForChain(X509Certificate certificate, OcspClient ocspClient, CrlClient crlClient, VriAdder vriAdder,
        BiConsumer<PdfName, X509Certificate> moreSignersAndCertificates) throws GeneralSecurityException, IOException, StreamParsingException, OperatorCreationException, OCSPException {
    List<byte[]> ocspResponses = new ArrayList<>();
    List<byte[]> crls = new ArrayList<>();
    List<byte[]> certs = new ArrayList<>();

    while (certificate != null) {
        System.out.println(certificate.getSubjectX500Principal().getName());
        X509Certificate issuer = getIssuerCertificate(certificate);
        certs.add(certificate.getEncoded());
        byte[] ocspResponse = ocspClient.getEncoded(certificate, issuer, null);
        if (ocspResponse != null) {
            System.out.println("  with OCSP response");
            ocspResponses.add(ocspResponse);
            X509Certificate ocspSigner = getOcspSignerCertificate(ocspResponse);
            if (ocspSigner != null) {
                System.out.printf("  signed by %s\n", ocspSigner.getSubjectX500Principal().getName());
            }
            moreSignersAndCertificates.accept(getOcspSignatureKey(ocspResponse), ocspSigner);
        } else {
           Collection<byte[]> crl = crlClient.getEncoded(certificate, null);
           if (crl != null && !crl.isEmpty()) {
               System.out.printf("  with %s CRLs\n", crl.size());
               crls.addAll(crl);
               for (byte[] crlBytes : crl) {
                   moreSignersAndCertificates.accept(getCrlSignatureKey(crlBytes), null);
               }
           }
        }
        certificate = issuer;
    }

    vriAdder.accept(ocspResponses, crls, certs);
}

interface VriAdder {
    void accept(Collection<byte[]> ocsps, Collection<byte[]> crls, Collection<byte[]> certs);
}