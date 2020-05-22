public void createPdf(String dest) throws IOException, DocumentException {
    // step 1
    Document document = new Document();
    // step 2
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
    // step 3
    document.open();
    // step 4
    writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO);
    Paragraph paragraph = new Paragraph();
    paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
    paragraph.setIndentationLeft(20);
    paragraph.setIndentationRight(20);
    paragraph.add("HelloWorld HelloWorld HelloWorld HelloWorld HelloWorld"+ 
        "HelloWorld HelloWorldHelloWorldHelloWorldHelloWorld"+
        "HelloWorld HelloWorld HelloWorld HelloWorldHelloWorldHelloWorld");
    document.add(paragraph);
    // step 5
    document.close();
}