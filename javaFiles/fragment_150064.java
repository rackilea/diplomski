private Rectangle getOutputPageSize(Rectangle pageSize, PdfReader reader, int page) throws IOException 
{ 
    PdfReaderContentParser parser = new PdfReaderContentParser(reader);
    TextMarginFinder finder = parser.processContent(page, new TextMarginFinder());
    Rectangle result = new Rectangle(finder.getLlx(), finder.getLly(), finder.getUrx(), finder.getUry());
    System.out.printf("Text/bitmap boundary: %f,%f to %f, %f\n", finder.getLlx(), finder.getLly(), finder.getUrx(), finder.getUry());
    return result;
}