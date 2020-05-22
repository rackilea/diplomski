private boolean validateSignature(Node signatureNode, Node bodyTag, PublicKey publicKey) {
    boolean signatureIsValid = false;
    try {
        // Create a DOM XMLSignatureFactory that will be used to unmarshal the
        // document containing the XMLSignature
        String providerName = System.getProperty
                ("jsr105Provider", "org.jcp.xml.dsig.internal.dom.XMLDSigRI");
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM",
                (Provider) Class.forName(providerName).newInstance());

        // Create a DOMValidateContext and specify a KeyValue KeySelector
        // and document context
        DOMValidateContext valContext = new DOMValidateContext(new X509KeySelector(publicKey), signatureNode);
        valContext.setIdAttributeNS((Element) bodyTag, "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Id");

        // Unmarshal the XMLSignature.
        XMLSignature signature = fac.unmarshalXMLSignature(valContext);
        // Validate the XMLSignature.
        signatureIsValid = signature.validate(valContext);

    } catch (Exception ex) {
        logger.error("An Error Raised while Signature Validation");
        logger.error("Cause: " + ex.getCause());
        logger.error("Message: " + ex.getMessage());
    }

    return signatureIsValid;
}