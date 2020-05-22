public void writePdf(OutputStream outputStream) throws Exception {
    Document document = new Document();
    PdfWriter.getInstance(document, outputStream);
    document.open();
    Paragraph paragraph = new Paragraph();
    paragraph.add(new Chunk("hello!"));
    document.add(paragraph);
    document.close();
}