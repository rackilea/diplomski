final DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
builder.setEntityResolver(new EntityResolver() {
  @Override
  public InputSource resolveEntity(String publicId, String systemId)
      throws SAXException, IOException {
    if (systemId.contains("xhtml1-transitional.dtd")) {
      return new InputSource(new FileReader(realPath + "/WEB-INF/dtd/xhtml1-transitional.dtd"));
    } else if (systemId.contains("xhtml-lat1.ent")) {
      return new InputSource(new FileReader(realPath + "/WEB-INF/dtd/xhtml-lat1.ent"));
    } else if (systemId.contains("xhtml-symbol.ent")) {
      return new InputSource(new FileReader(realPath + "/WEB-INF/dtd/xhtml-symbol.ent"));
    } else if (systemId.contains("xhtml-special.ent")) {
      return new InputSource(new FileReader(realPath + "/WEB-INF/dtd/xhtml-special.ent"));
    } else {
      return null;
    }
  }
});
final ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes("UTF-8"));
final Document doc = builder.parse(inputStream);
inputStream.close();
final ITextRenderer renderer = new ITextRenderer(26f * 4f / 3f, 26);
renderer.setDocument(doc, request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort());
renderer.layout();