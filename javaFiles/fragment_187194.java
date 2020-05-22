private static void printStyle(Style style) throws TransformerException {

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    SLDTransformer transformer = new SLDTransformer();
    transformer.setIndentation(2);
    transformer.transform(style, bos);
    String styleStr = bos.toString();
    System.out.println(styleStr);
  }