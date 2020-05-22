public boolean isAtom(String URL) throws ParserConfigurationException, SAXException, IOException{
    DocumentBuilderFactory f = DocumentBuilderFActory.newInstance();
    f.setNamespaceAware(true);
    DocumentBuilder builder = f.newInstance().newDocumentBuilder();
    Document doc = builder.parse(URL);
    Element e = doc.getDocumentElement(); 
    return e.getLocalName().equals("feed") && 
            e.getNamespaceURI().equals("http://www.w3.org/2005/Atom");
}