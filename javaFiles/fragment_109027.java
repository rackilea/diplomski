public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfDictionary page = reader.getPageN(1);
    PdfArray annots = page.getAsArray(PdfName.ANNOTS);
    PdfDictionary sticky = annots.getAsDict(0);
    PdfArray stickyRect = sticky.getAsArray(PdfName.RECT);
    PdfRectangle stickyRectangle = new PdfRectangle(
        stickyRect.getAsNumber(0).floatValue() - 120, stickyRect.getAsNumber(1).floatValue() -70,
        stickyRect.getAsNumber(2).floatValue(), stickyRect.getAsNumber(3).floatValue() - 30
    );
    sticky.put(PdfName.RECT, stickyRectangle);
    PdfDictionary popup = annots.getAsDict(1);
    PdfArray popupRect = popup.getAsArray(PdfName.RECT);
    PdfRectangle popupRectangle = new PdfRectangle(
        popupRect.getAsNumber(0).floatValue() - 250, popupRect.getAsNumber(1).floatValue(),
        popupRect.getAsNumber(2).floatValue(), popupRect.getAsNumber(3).floatValue() - 250
    );
    popup.put(PdfName.RECT, popupRectangle);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    stamper.close();
}