public void handleEvent(Event event) {
    PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
    PdfDocument pdf = docEvent.getDocument();
    PdfPage page = docEvent.getPage();
    PdfCanvas pdfCanvas = new PdfCanvas(
        page.newContentStreamBefore(), page.getResources(), pdf);
    pdfCanvas.addXObject(stationery, 0, 0);
}