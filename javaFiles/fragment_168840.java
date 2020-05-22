// output the result to a stream:
try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
    XMLUtils.outputDOM(result, baos, true);
}

// add key info to the encrypted key
org.apache.xml.security.keys.KeyInfo encryptedKeyKeyInfo = new org.apache.xml.security.keys.KeyInfo(document);
  // not sure the following is needed 
encryptedKeyKeyInfo.getElement()
    .setAttributeNS(
        "http://www.w3.org/2000/xmlns/", 
        "xmlns:dsig", 
        "http://www.w3.org/2000/09/xmldsig#");
encryptedKey.setKeyInfo(encryptedKeyKeyInfo);
encryptedKeyKeyInfo.add(publicKey);

// encrypt a specific node rather than the whole document
NodeList nodeList = document.getElementsByTagNameNS(ns, qName.getLocalPart());
// not sure if this'll work for embedded nodes
for (int i = 0, n = nodeList.getLength(); i < n; i++) {
    Element elementToEncrypt = (Element) nodeList.item(i);
    document = cipher.doFinal(document, elementToEncrypt, false); 
    // last parameter says to either encrypt the children of 'elementToEncrypt'
    // or the element itself
}