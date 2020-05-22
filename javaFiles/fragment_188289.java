/* Create a temporary PDF file.*/
private File createPdf(String fileName) throws IOException {
    // Create a document and add a page to it
    final PDDocument document = new PDDocument();
    PDPage page = new PDPage();
    document.addPage(page);

    // Create a new font object selecting one of the PDF base fonts
    PDFont font = PDType1Font.HELVETICA_BOLD;

    // Start a new content stream which will "hold" the to be created content
    PDPageContentStream contentStream = new PDPageContentStream(document, page);

    // Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
    contentStream.beginText();
    contentStream.setFont(font, 12);
    contentStream.newLineAtOffset(100, 700);
    contentStream.showText("Hello World");
    contentStream.endText();

    // Make sure that the content stream is closed:
    contentStream.close();

    // Save the results and ensure that the document is properly closed:
    File file = File.createTempFile(fileName, ".pdf");
    document.save(file);
    document.close();
    return file;
}