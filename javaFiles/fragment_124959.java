public class LineNumber {

    public static void main(String[] args) throws Exception {

        SAXReader reader = new MySAXReader();
        reader.setDocumentFactory(new LocatorAwareDocumentFactory());

        Document doc = reader
                .read(new StringReader("<root foo='bar' > \n<alfa/>\n<beta/>\n<gamma/>\n</root>\n"));
        doc.accept(new VisitorSupport() {
            @Override
            public void visit(Element node) {
                System.out.printf("%d: %s\n",
                        ((LocationAwareElement) node).getLineNumber(),
                        node.getName());
            }
        });

    }

    static class MySAXReader extends SAXReader {

        @Override
        protected SAXContentHandler createContentHandler(XMLReader reader) {
            return new MySAXContentHandler(getDocumentFactory(),
                    getDispatchHandler());
        }

        @Override
        public void setDocumentFactory(DocumentFactory documentFactory) {
            super.setDocumentFactory(documentFactory);
        }

    }

    static class MySAXContentHandler extends SAXContentHandler {

        private Locator locator;

        // this is already in SAXContentHandler, but private
        private DocumentFactory documentFactory;

        public MySAXContentHandler(DocumentFactory documentFactory,
                ElementHandler elementHandler) {
            super(documentFactory, elementHandler);
            this.documentFactory = documentFactory;
        }

        @Override
        public void setDocumentLocator(Locator documentLocator) {
            super.setDocumentLocator(documentLocator);
            this.locator = documentLocator;
            if (documentFactory instanceof LocatorAwareDocumentFactory) {
                ((LocatorAwareDocumentFactory)documentFactory).setLocator(documentLocator);
            }

        }

        public Locator getLocator() {
            return locator;
        }
    }

    static class LocatorAwareDocumentFactory extends DocumentFactory {

        private Locator locator;

        public LocatorAwareDocumentFactory() {
            super();
        }

        public void setLocator(Locator locator) {
            this.locator = locator;
        }

        @Override
        public Element createElement(QName qname) {
            LocationAwareElement element = new LocationAwareElement(qname);
            if (locator != null)
                element.setLineNumber(locator.getLineNumber());
            return element;
        }

    }

    /**
     * An Element that is aware of it location (line number in) in the source document
     */
    static class LocationAwareElement extends DefaultElement {

        private int lineNumber = -1;

        public LocationAwareElement(QName qname) {
            super(qname);
        }

        public LocationAwareElement(QName qname, int attributeCount) {
            super(qname, attributeCount);

        }

        public LocationAwareElement(String name, Namespace namespace) {
            super(name, namespace);

        }

        public LocationAwareElement(String name) {
            super(name);

        }

        public int getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }

    }

}