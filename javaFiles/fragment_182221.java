private void buildSignatureBlock() {
    // Create a DOM XMLSignatureFactory that will be used to generate the signature.
    XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

    // Create a Reference to the document (in this case, you are signing just the element with
    // Id="Body", so a URI of "#Body" signifies that), and also specify the SHA1 digest algorithm
    // and the xml-exc-c14n# Transform.
    Reference ref = null;
    try {
        ref = fac.newReference
                ("#Body", fac.newDigestMethod(DigestMethod.SHA1, null),
                        Collections.singletonList
                                (fac.newTransform
                                        ("http://www.w3.org/2001/10/xml-exc-c14n#", (TransformParameterSpec) null)),
                        null, null);
    } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    // Create the SignedInfo.
    SignedInfo si = null;
    try {
        si = fac.newSignedInfo
                (fac.newCanonicalizationMethod
                                (CanonicalizationMethod.EXCLUSIVE,
                                        (C14NMethodParameterSpec) null),
                        fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                        Collections.singletonList(ref));
    } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    // Load the KeyStore and get the signing key and certificate.
    KeyStore ks = null;
    try {
        ks = KeyStore.getInstance("JKS");
    } catch (KeyStoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        ks.load(new FileInputStream("src/main/resources/xml/project/keys/project.jks"), "password".toCharArray());
    } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    KeyStore.PrivateKeyEntry keyEntry = null;

    try {
        keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry
                ("1", new KeyStore.PasswordProtection("password".toCharArray()));
    } catch (NoSuchAlgorithmException | UnrecoverableEntryException | KeyStoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    X509Certificate cert = (X509Certificate) keyEntry.getCertificate();

    // Create the KeyInfo containing the X509Data.
    KeyInfoFactory kif = fac.getKeyInfoFactory();
    List x509Content = new ArrayList();
    String issuerName = cert.getIssuerX500Principal().getName();
    BigInteger serialNumber = cert.getSerialNumber();
    X509IssuerSerial issuer = kif.newX509IssuerSerial(issuerName, serialNumber);
    x509Content.add(issuer);
    x509Content.add(cert);
    X509Data xd = kif.newX509Data(x509Content);
    KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

    // Create a DOMSignContext and specify the RSA PrivateKey and location of the resulting XMLSignature's parent element.
    Element envHeaderSig = (Element) document.getElementsByTagName("SOAP-SEC:Signature").item(0);

    // Create the XMLSignature, but don't sign it yet.
    XMLSignature signature = fac.newXMLSignature(si, ki);

    try {
        Node envelope = document.getFirstChild();
        Node header = envelope.getFirstChild();
        DOMSignContext sigContext = new DOMSignContext(keyEntry.getPrivateKey(), header);
        // Need to distinguish the Signature element in DSIG (from that in SOAP)
        sigContext.putNamespacePrefix(XMLSignature.XMLNS, "ds");

        // register Body ID attribute   sigContext.setIdAttributeNS(getNextSiblingElement(header),"http://schemas.xmlsoap.org/soap/security/2000-12","id");
        signature.sign(sigContext);

    } catch (MarshalException | XMLSignatureException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    ///VALIDATE the signature
    Element sigElement = envHeaderSig;
    DOMValidateContext valContext =
            new DOMValidateContext(cert.getPublicKey(), sigElement);
    Element envelope = getFirstChildElement(document);
    Element header = getFirstChildElement(envelope);
    valContext.setIdAttributeNS
            (getNextSiblingElement(header),
                    "http://schemas.xmlsoap.org/soap/security/2000-12","id");
    boolean isValid = false;
    try {
        isValid = signature.validate(valContext);
    } catch (XMLSignatureException e) {
        e.printStackTrace();
    }
    System.out.println("Validating the signature... " +
            (isValid ? "valid" : "invalid"));
}