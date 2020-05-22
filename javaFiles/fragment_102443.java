public void rotatePdf(String originalPdfFile, String outputPdfFile, int degrees) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(originalPdfFile);
    for (int i = 1; i <= reader.getNumberOfPages(); i++) {
        PdfDictionary dictionary = reader.getPageN(i);
        dictionary.put(PdfName.ROTATE, new PdfNumber(degrees));
    }
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputPdfFile));
    stamper.close();
    reader.close();
}