public PDDocument prerparePdfToAppend()
{
    final PDDocument document = new PDDocument();
    final PDPage sourcePage = new PDPage();
    document.addPage(sourcePage);

    PDPageContentStream contentStream = new PDPageContentStream(document, sourcePage);
    contentStream.beginText();
    contentStream.setFont(PDType1Font.COURIER, 12);
    contentStream.showText("Name: " + firstName + " " + lastName);
    contentStream.newLine();
    ...
    contentStream.endText();
    contentStream.close();

    return document;
}