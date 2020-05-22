doc.getDocumentElement().normalize();
Element elmt = doc.getDocumentElement();
NodeList nl = elmt.getChildNodes();
String k, v;
for(int i = 0; i < nl.getLength(); i++) {
    Node n = nl.item(i);
    if(n.getNodeType() == Node.ELEMENT_NODE){
        NamedNodeMap attrs = n.getAttributes();
        System.out.println(attrs.getNamedItem("id").getTextContent() + " : " + n.getTextContent());
    }
}