String str = "<paragraph>" + //
        "<link>XML</link>" + //
        " is a " + //
        "<strong>browser based XML editor</strong>" + //
        "editor allows users to edit XML data in an intuitive word processor." + //
        "</paragraph>";
Document domDoc = null;
try {
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
    domDoc = docBuilder.parse(bis);
} catch (Exception e) {
    e.printStackTrace();
}
DocumentTraversal traversal = (DocumentTraversal) domDoc;
NodeIterator iterator = traversal.createNodeIterator(domDoc.getDocumentElement(), NodeFilter.SHOW_ELEMENT, null, true);
for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
    String tagname = ((Element) n).getTagName();
    System.out.println(tagname + "=" + getFirstLevelTextContent(n));
}