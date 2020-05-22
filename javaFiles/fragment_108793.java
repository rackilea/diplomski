XmlObject xmlObject = ...;
XmlObject xmlObject1 = ...;

Document myDoc = myXmlObject.getMyXmlObject().getDomNode().getOwnerDocument();
Node newNode = myDoc.importNode(myXmlObject2.getMyXmlObject().getDomNode(), true);
myDoc.getDocumentElement().appendChild(newNode);
XmlObject obj = XmlObject.Factory.parse(myDoc);