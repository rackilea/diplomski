public static void main(String[] args) throws Exception {
    String xml = "<root>" +
                   "<folder name=\"A\">" +
                     "<folder name=\"B\">" +
                       "<book name=\"Learn Java\">" +
                         "<chapter name=\"Hello, World!\"/>" +
                         "<chapter name=\"Variables and Types\"/>" +
                       "</book>" +
                     "</folder>" +
                   "</folder>" +
                 "</root>";
    XMLInputFactory factory = XMLInputFactory.newFactory();
    XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(xml));
    try {
        reader.nextTag(); // Position on root element
        String tagName = reader.getLocalName();
        if (! tagName.equals("root"))
            throw new XMLStreamException("Expected <root> element, found: " + tagName, reader.getLocation());
        parseRoot(reader);
    } finally {
        reader.close();
    }
}

private static void parseRoot(XMLStreamReader reader) throws XMLStreamException {
    while (reader.nextTag() != XMLStreamConstants.END_ELEMENT) {
        String tagName = reader.getLocalName();
        if (tagName.equals("folder")) {
            parseFolder(reader, Collections.emptyList());
        } else {
            throw new XMLStreamException("Expected <folder> element, found: " + tagName, reader.getLocation());
        }
    }
}

private static void parseFolder(XMLStreamReader reader, List<String> parentPaths) throws XMLStreamException {
    String folderName = reader.getAttributeValue(null, "name");
    if (folderName == null)
        throw new XMLStreamException("Missing 'name' attribute on <folder> element", reader.getLocation());
    List<String> folderPath = new ArrayList<>(parentPaths.size() + 1);
    folderPath.addAll(parentPaths);
    folderPath.add(folderName);
    while (reader.nextTag() != XMLStreamConstants.END_ELEMENT) {
        String tagName = reader.getLocalName();
        if (tagName.equals("folder")) {
            parseFolder(reader, folderPath);
        } else if (tagName.equals("book")) {
            parseBook(reader, folderPath);
        } else {
            throw new XMLStreamException("Expected <folder> or <book> element, found: " + tagName, reader.getLocation());
        }
    }
}

private static void parseBook(XMLStreamReader reader, List<String> folderPath) throws XMLStreamException {
    String bookName = reader.getAttributeValue(null, "name");
    if (bookName == null)
        throw new XMLStreamException("Missing 'name' attribute on <book> element", reader.getLocation());
    while (reader.nextTag() != XMLStreamConstants.END_ELEMENT) {
        String tagName = reader.getLocalName();
        if (tagName.equals("chapter")) {
            parseChapter(reader, folderPath, bookName);
        } else {
            throw new XMLStreamException("Expected <chapter> element, found: " + tagName, reader.getLocation());
        }
    }
}

private static void parseChapter(XMLStreamReader reader, List<String> folderPath, String bookName) throws XMLStreamException {
    String chapterName = reader.getAttributeValue(null, "name");
    if (chapterName == null)
        throw new XMLStreamException("Missing 'name' attribute on <chapter> element", reader.getLocation());
    if (! reader.getElementText().isEmpty())
        throw new XMLStreamException("<chapter> element must be empty", reader.getLocation());
    System.out.println("Found:");
    System.out.println("  Folder:  " + folderPath);
    System.out.println("  Book:    " + bookName);
    System.out.println("  Chapter: " + chapterName);
}