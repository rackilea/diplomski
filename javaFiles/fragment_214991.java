public void saveTo(Document document, File file) {
  try (Writer writer = new FileWriter(file)) {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    /*
     * Customize your transformer here:
     * - Indentation
     * - Encoding
     * - ...
     */
    transformer.transform(new DOMSource(document), new StreamResult(writer));
  }
}