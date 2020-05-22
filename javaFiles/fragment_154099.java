public static void main(String[] args) throws IOException, COSVisitorException {
    PDDocument doc = new PDDocument();
    PDPage page = new PDPage();
    doc.addPage( page );
    PDPageContentStream contentStream = new PDPageContentStream(doc, page);

    String[][] content = {
        {"Name"," Time "},
        {"HTC","01:25"},
        {"Samsung Tab2","05:30"}
    } ;

    drawTable(page, contentStream, 700, 100, content);

    contentStream.close();
    doc.save("h:\\test.pdf" );
}