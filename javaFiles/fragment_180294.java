// Find Signature element.
NodeList nl =
    doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
if (nl.getLength() == 0) {
    throw new Exception("Cannot find Signature element");
}

// Create a DOMValidateContext and specify a KeySelector
// and document context.
DOMValidateContext valContext = new DOMValidateContext
    (new X509KeySelector(), nl.item(0));

// Unmarshal the XMLSignature.
XMLSignature signature = fac.unmarshalXMLSignature(valContext);

// Validate the XMLSignature.
boolean coreValidity = signature.validate(valContext);