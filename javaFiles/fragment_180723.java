public class ReadXml {

    public static void main(String[] args) throws Exception {
        new ReadXml().read();
    }

    public void read() throws Exception {

        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".xml")) {

                Handler handler = new Handler();
                saxParser.parse(file, handler);
                save(handler, file.getName() + ".txt");
            }
        }
    }

    private void save(Handler handler, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.append(handler.getFrom());
        writer.newLine();
        writer.append(handler.getTo());
        writer.newLine();
        writer.append(handler.getHead());
        writer.newLine();
        writer.append(handler.getBody());
        writer.newLine();
        writer.close();
    }

    private class Handler extends DefaultHandler {

        private StringBuilder content;
        private String to;
        private String from;
        private String body;
        private String head;

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {

            content = new StringBuilder();
        }

        @Override
        public void characters(char ch[], int start, int length)
                throws SAXException {
            content.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {

            if ("to".equals(qName)) {
                to = content.toString();
            } else if ("from".equals(qName)) {
                from = content.toString();
            } else if ("body".equals(qName)) {
                body = content.toString();
            } else if ("head".equals(qName)) {
                head = content.toString();
            }
        }

        public String getTo() {
            return to;
        }

        public String getFrom() {
            return from;
        }

        public String getBody() {
            return body;
        }

        public String getHead() {
            return head;
        }

    }
}