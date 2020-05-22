private static Document sign(Document doc) throws InstantiationException, IllegalAccessException, ClassNotFoundException,
            NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyException, MarshalException, XMLSignatureException,
            FileNotFoundException, TransformerException {

        String providerName = System.getProperty("jsr105Provider", "org.jcp.xml.dsig.internal.dom.XMLDSigRI");

        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM", (Provider) Class.forName(providerName).newInstance());

        DigestMethod digestMethod = fac.newDigestMethod(DigestMethod.SHA256, null);
        Transform transform = fac.newTransform(ENVELOPED, (TransformParameterSpec) null);
        Reference reference = fac.newReference("", digestMethod, singletonList(transform), null, null);
        SignatureMethod signatureMethod = fac.newSignatureMethod("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256", null);
        CanonicalizationMethod canonicalizationMethod = fac.newCanonicalizationMethod(EXCLUSIVE, (C14NMethodParameterSpec) null);

        // Create the SignedInfo
        SignedInfo si = fac.newSignedInfo(canonicalizationMethod, signatureMethod, singletonList(reference));


        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);

        KeyPair kp = kpg.generateKeyPair();

        KeyInfoFactory kif = fac.getKeyInfoFactory();
        KeyValue kv = kif.newKeyValue(kp.getPublic());

        // Create a KeyInfo and add the KeyValue to it
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv));
        DOMSignContext dsc = new DOMSignContext(kp.getPrivate(), doc.getDocumentElement());

        XMLSignature signature = fac.newXMLSignature(si, ki);
        signature.sign(dsc);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();

        // output the resulting document
        OutputStream os;

        os = new FileOutputStream("xmlOut.xml");

        trans.transform(new DOMSource(doc), new StreamResult(os));
        return doc;

    }