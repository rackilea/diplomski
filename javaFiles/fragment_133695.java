public void setDocumentFromString(String content) {
    InputSource is = new InputSource(new BufferedReader(new StringReader(content)));
    Document dom = XMLResource.load(is).getDocument();

    setDocument(dom, null);
}