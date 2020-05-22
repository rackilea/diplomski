public static String processXHTML(String sourceFileName, String outputXhtml,
        String xslFilePath) throws ParserConfigurationException, SAXException, IOException,
        TransformerException {

    Charset charset = StandardCharsets.UTF_8;
    Path path = Paths.get(sourceFileName);
    String source = new String(Files.readAllBytes(path), charset);
    source = source.replaceAll("\\&(amp|lt|gt|quot);", "\u0001$1;");
    source = StringEscapeUtils.unescapeHtml4(source);
    source = source.replace('\u0001', '&');
    byte[] bytes = source.getBytes(charset);
    ByteArrayInputStream bais = new ByteArrayInputStream(bytes);

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docbuilder = factory.newDocumentBuilder();
    docbuilder.setEntityResolver(new EntityResolver() {
        @Override
        public InputSource resolveEntity(String publicId, String systemId)
                    throws SAXException, IOException {
            System.out.printf("resolveEntity PUBLIC %s SYSTEM %s%n", publicId, systemId);
            return new InputSource(new StringReader(""));
        }
    });
    //Document doc = docbuilder.parse(new FileInputStream(sourceFileName));
    Document doc = docbuilder.parse(bais);