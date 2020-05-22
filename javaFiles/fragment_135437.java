class Background implements IEventHandler {
    PdfXObject stationery;

    public Background(PdfDocument pdf, String src) throws IOException {
        PdfDocument template = new PdfDocument(new PdfReader(src));
        PdfPage page = template.getPage(1);
        stationery = page.copyAsFormXObject(pdf);
        template.close();
    }

    @Override
    public void handleEvent(Event event) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
        PdfDocument pdf = docEvent.getDocument();
        PdfPage page = docEvent.getPage();
        PdfCanvas pdfCanvas = new PdfCanvas(
            page.newContentStreamBefore(), page.getResources(), pdf);
        pdfCanvas.addXObject(stationery, 0, 0);
        Rectangle rect = new Rectangle(36, 32, 36, 64);
        Canvas canvas = new Canvas(pdfCanvas, pdf, rect);
        canvas.add(
            new Paragraph(String.valueOf(pdf.getNumberOfPages()))
                .setFontSize(48).setFontColor(Color.WHITE));
        canvas.close();
    }
}