ImageData img = ImageDataFactory.create("src/test/resources/my_image.png");
PdfImageXObject imgXObj = new PdfImageXObject(img);
List<PdfWidgetAnnotation> widgets = button.getWidgets();
for (PdfWidgetAnnotation widget : widgets) {
    Rectangle rectangle = widget.getRectangle().toRectangle();
    PdfFormXObject xObject = new PdfFormXObject(rectangle);
    PdfCanvas canvas = new PdfCanvas(xObject, pdfDocument);
    canvas.addXObject(imgXObj, rectangle.getWidth(), 0, 0, rectangle.getHeight(), rectangle.getLeft(), rectangle.getBottom());
    widget.setNormalAppearance(xObject.getPdfObject());
}