public void createPdf(String src, String dest) throws IOException {
    ConverterProperties properties = new ConverterProperties();
    properties.setBaseUri(new File(src).getParent());
    List<IElement> elements =
            HtmlConverter.convertToElements(new FileInputStream(src), properties);
    PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
    pdf.setTagged();
    Document document = new Document(pdf);
    document.setMargins(100, 50, 50, 100);
    for (IElement element : elements) {
        document.add((IBlockElement)element);
    }
    document.close();
}