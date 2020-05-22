String xml = "<nodes>\n"
        + "    <RegDef>This <i>text</i> have i node.</RegDef>\n"
        + "    <RegDef>This text doesn't have i atribute.</RegDef>\n"
        + "</nodes>";
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = dbf.newDocumentBuilder();
Document document = builder.parse(new InputSource(new StringReader(xml)));

NodeList regDefNodes = document.getElementsByTagName("RegDef");
int size = regDefNodes.getLength();
for(int i = 0; i < size; i++) {
    Element regDef = (Element)regDefNodes.item(i);
    Element newRegDef = wrapWordsInContents(regDef, document);
    Element parent = (Element)regDef.getParentNode();
    parent.replaceChild(newRegDef, regDef);
}