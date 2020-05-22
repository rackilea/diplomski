Document document = XMLUtils.read(is);
// specific to my case, lookup the RSA key value node, and from there go to the parents
NodeList keyInfoList = document.getElementsByTagNameNS(XMLSignature.XMLNS, Constants._TAG_RSAKEYVALUE);
assert keyInfoList.getLength() == 1;
DOMStructure domStructure = new DOMStructure(keyInfoList.item(0).getParentNode().getParentNode());
// from here on it's generic again
KeyInfo keyInfo = KeyInfoFactory.getInstance("DOM").unmarshalKeyInfo(domStructure);
KeyValue keyValue = (KeyValue) keyInfo.getContent().get(0);
publicKey = keyValue.getPublicKey();