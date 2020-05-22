public void mergeTwoPagesIntoOne(String originalPdfFile, String outputPdfFile) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(originalPdfFile);
    Document doc = new Document(new RectangleReadOnly(842f, 595f), 0, 0, 0, 0);
    PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(outputPdfFile));
    doc.open();
    int totalPages = reader.getNumberOfPages();
    for (int i = 1; i <= totalPages; i = i + 2) {
        doc.newPage();
        PdfContentByte cb = writer.getDirectContent();
        PdfImportedPage page = writer.getImportedPage(reader, i); // page #1

        float documentWidth = doc.getPageSize().getWidth() / 2;
        float documentHeight = doc.getPageSize().getHeight();
        if (i > 1)
            documentHeight = documentHeight - 50f;

        float pageWidth = page.getWidth();
        float pageHeight = page.getHeight();

        float widthScale = documentWidth / pageWidth;
        float heightScale = documentHeight / pageHeight;
        float scale = Math.min(widthScale, heightScale);

        float offsetX = (documentWidth - (pageWidth * scale)) / 2;
        float offsetY = 0f;

        cb.addTemplate(page, scale, 0, 0, scale, offsetX, offsetY);

        if (i+1 <= totalPages) {
            PdfImportedPage page2 = writer.getImportedPage(reader, i+1); // page #2

            pageWidth = page.getWidth();
            pageHeight = page.getHeight();

            widthScale = documentWidth / pageWidth;
            heightScale = documentHeight / pageHeight;
            scale = Math.min(widthScale, heightScale);

            offsetX = ((documentWidth - (pageWidth * scale)) / 2) + documentWidth;
            cb.addTemplate(page2, scale, 0, 0, scale, offsetX, offsetY);
        }
    }
    doc.close();
}