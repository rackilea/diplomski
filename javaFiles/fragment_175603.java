PdfReader reader = new PdfReader(pdf);
PrintWriter out = new PrintWriter(new FileOutputStream(txt));
Rectangle rect = new Rectangle(70, 80, 490, 580);
RenderFilter filter = new RegionTextRenderFilter(rect);
TextExtractionStrategy strategy;
for (int i = 1; i <= reader.getNumberOfPages(); i++) {
    strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
    out.println(PdfTextExtractor.getTextFromPage(reader, i, strategy));
}
out.flush();
out.close();
reader.close();