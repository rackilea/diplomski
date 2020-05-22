PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC));
PdfObject obj;
for (int i = 1; i <= pdfDoc.getNumberOfPdfObjects(); i++) {
    obj = pdfDoc.getPdfObject(i);
    if (obj != null && obj.isStream()) {
        byte[] b;
        try {
            b = ((PdfStream) obj).getBytes();
        } catch (PdfException exc) {
            b = ((PdfStream) obj).getBytes(false);
        }
        FileOutputStream fos = new FileOutputStream(String.format(DEST, i));
        fos.write(b);
        fos.close();
    }
}
pdfDoc.close();