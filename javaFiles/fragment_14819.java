public Image createBarcode(PdfContentByte cb, String text,
    float mh, float mw) throws BadElementException {
    BarcodePDF417 pf = new BarcodePDF417();
    pf.setText("BarcodePDF417 barcode");
    Rectangle size = pf.getBarcodeSize();
    PdfTemplate template = cb.createTemplate(
        mw * size.getWidth(), mh * size.getHeight());
    pf.placeBarcode(template, BaseColor.BLACK, mh, mw);
    return Image.getInstance(template);
}