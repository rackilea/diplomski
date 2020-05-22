DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document XMLbook = dBuilder.parse(fXmlFile);
Node root = XMLbook.getFirstChild(); //(1)
Node book = XMLbook.getElementsByTagName("BOOK").item(0);//(2)
NodeList chapterNodes = ((Element)book).getElementsByTagName("Chapter");
if(chapterNodes != null && chapterNodes.getLength() > 0) {
    Node chapterNode = chapterNodes.item(chapterNodes.getLength() - 1);
    NodeList subChapterNodes = ((Element)chapterNode).getElementsByTagName("Subchapter");
    if(subChapterNodes != null && subChapterNodes.getLength() > 0) {
        Node subChapterNode = subChapterNodes.item(subChapterNodes.getLength() - 1);
        System.out.println(subChapterNode.getNodeName());
    }
}