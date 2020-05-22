try (   PdfWriter writer = new PdfWriter(...);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc)   ) {
    ImageData data = ImageDataFactory.create(IMAGE_DATA);
    Image img = new Image(data);

    PdfLayer pdflayer = new PdfLayer("main layer", pdfDoc);
    pdflayer.setOn(true); 

    // using a Canvas, to allow iText layout'ing the image
    PdfCanvas pdfCanvas = new PdfCanvas(pdfDoc.addNewPage());
    try (   Canvas canvas = new Canvas(pdfCanvas, pdfDoc, document.getPageEffectiveArea(pdfDoc.getDefaultPageSize()))   ) {
        canvas.add(new Paragraph("This image is added using a Canvas:"));
        pdfCanvas.beginLayer(pdflayer);
        canvas.add(img);
        pdfCanvas.endLayer();
        canvas.add(new Paragraph("And this image is added immediately:"));
    }

    // or directly 
    pdfCanvas.beginLayer(pdflayer);
    pdfCanvas.addImage(data, 100, 100, false);
    pdfCanvas.endLayer();
}