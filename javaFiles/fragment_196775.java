public void createPdf(String filename, PdfReader[] readers) throws IOException, DocumentException {
    Document document = new Document();
    PdfCopy copy = new PdfCopy(document, new FileOutputStream(filename));
    copy.setMergeFields();
    document.open();
    for (PdfReader reader : readers) {
        copy.addDocument(reader);
    }
    document.close();
    for (PdfReader reader : readers) {
        reader.close();
    }
}