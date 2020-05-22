public static void main(String[] args) throws IOException, XMLStreamException {
    try (FileInputStream in = new FileInputStream("test.xml")) {

        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(in);

        LinkedList<String> path = new LinkedList<>();

        int next;
        while ((next = reader.next()) != XMLStreamConstants.END_DOCUMENT) {
            switch (next) {
                case XMLStreamConstants.START_ELEMENT:
                    // push the name of the current element onto the stack
                    path.addLast(reader.getLocalName());
                    // print the path with '/' delimiters
                    System.out.println("Reading /" + String.join("/", path));
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    // pop the name of the element being closed
                    path.removeLast();
                    break;
            }
        }
    }
}