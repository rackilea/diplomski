static X509Certificate getOcspSignerCertificate(byte[] basicResponseBytes) throws CertificateException, OCSPException, OperatorCreationException {
    JcaX509CertificateConverter converter = new JcaX509CertificateConverter().setProvider(BouncyCastleProvider.PROVIDER_NAME);
    BasicOCSPResponse borRaw = BasicOCSPResponse.getInstance(basicResponseBytes);
    BasicOCSPResp bor = new BasicOCSPResp(borRaw);

    for (final X509CertificateHolder x509CertificateHolder : bor.getCerts()) {
        X509Certificate x509Certificate = converter.getCertificate(x509CertificateHolder);

        JcaContentVerifierProviderBuilder jcaContentVerifierProviderBuilder = new JcaContentVerifierProviderBuilder();
        jcaContentVerifierProviderBuilder.setProvider(BouncyCastleProvider.PROVIDER_NAME);
        final PublicKey publicKey = x509Certificate.getPublicKey();
        ContentVerifierProvider contentVerifierProvider = jcaContentVerifierProviderBuilder.build(publicKey);

        if (bor.isSignatureValid(contentVerifierProvider))
            return x509Certificate;
    }

    return null;
}

static PdfName getOcspSignatureKey(byte[] basicResponseBytes) throws NoSuchAlgorithmException, IOException {
    BasicOCSPResponse basicResponse = BasicOCSPResponse.getInstance(basicResponseBytes);
    byte[] signatureBytes = basicResponse.getSignature().getBytes();
    DEROctetString octetString = new DEROctetString(signatureBytes);
    byte[] octetBytes = octetString.getEncoded();
    byte[] octetHash = hashBytesSha1(octetBytes);
    PdfName octetName = new PdfName(Utilities.convertToHex(octetHash));
    return octetName;
}

static PdfName getCrlSignatureKey(byte[] crlBytes) throws NoSuchAlgorithmException, IOException, CRLException, CertificateException {
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    X509CRL crl = (X509CRL)cf.generateCRL(new ByteArrayInputStream(crlBytes));
    byte[] signatureBytes = crl.getSignature();
    DEROctetString octetString = new DEROctetString(signatureBytes);
    byte[] octetBytes = octetString.getEncoded();
    byte[] octetHash = hashBytesSha1(octetBytes);
    PdfName octetName = new PdfName(Utilities.convertToHex(octetHash));
    return octetName;
}

static X509Certificate getIssuerCertificate(X509Certificate certificate) throws IOException, StreamParsingException {
    String url = getCACURL(certificate);
    if (url != null && url.length() > 0) {
        HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
        if (con.getResponseCode() / 100 != 2) {
            throw new IOException(MessageLocalization.getComposedMessage("invalid.http.response.1", con.getResponseCode()));
        }
        InputStream inp = (InputStream) con.getContent();
        byte[] buf = new byte[1024];
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        while (true) {
            int n = inp.read(buf, 0, buf.length);
            if (n <= 0)
                break;
            bout.write(buf, 0, n);
        }
        inp.close();

        X509CertParser parser = new X509CertParser();
        parser.engineInit(new ByteArrayInputStream(bout.toByteArray()));
        return (X509Certificate) parser.engineRead();
    }
    return null;
}

static String getCACURL(X509Certificate certificate) {
    ASN1Primitive obj;
    try {
        obj = getExtensionValue(certificate, Extension.authorityInfoAccess.getId());
        if (obj == null) {
            return null;
        }
        ASN1Sequence AccessDescriptions = (ASN1Sequence) obj;
        for (int i = 0; i < AccessDescriptions.size(); i++) {
            ASN1Sequence AccessDescription = (ASN1Sequence) AccessDescriptions.getObjectAt(i);
            if ( AccessDescription.size() != 2 ) {
                continue;
            }
            else if (AccessDescription.getObjectAt(0) instanceof ASN1ObjectIdentifier) {
                ASN1ObjectIdentifier id = (ASN1ObjectIdentifier)AccessDescription.getObjectAt(0);
                if ("1.3.6.1.5.5.7.48.2".equals(id.getId())) {
                    ASN1Primitive description = (ASN1Primitive)AccessDescription.getObjectAt(1);
                    String AccessLocation =  getStringFromGeneralName(description);
                    if (AccessLocation == null) {
                        return "" ;
                    }
                    else {
                        return AccessLocation ;
                    }
                }
            }
        }
    } catch (IOException e) {
        return null;
    }
    return null;
}

static ASN1Primitive getExtensionValue(X509Certificate certificate, String oid) throws IOException {
    byte[] bytes = certificate.getExtensionValue(oid);
    if (bytes == null) {
        return null;
    }
    ASN1InputStream aIn = new ASN1InputStream(new ByteArrayInputStream(bytes));
    ASN1OctetString octs = (ASN1OctetString) aIn.readObject();
    aIn = new ASN1InputStream(new ByteArrayInputStream(octs.getOctets()));
    return aIn.readObject();
}

static String getStringFromGeneralName(ASN1Primitive names) throws IOException {
    ASN1TaggedObject taggedObject = (ASN1TaggedObject) names ;
    return new String(ASN1OctetString.getInstance(taggedObject, false).getOctets(), "ISO-8859-1");
}

static byte[] hashBytesSha1(byte[] b) throws NoSuchAlgorithmException {
    MessageDigest sh = MessageDigest.getInstance("SHA1");
    return sh.digest(b);
}