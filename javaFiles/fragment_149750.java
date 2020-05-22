public static void main(String[] args) throws IOException
{
    PDDocument doc = new PDDocument();
    PDPage page1 = new PDPage();
    doc.addPage(page1);
    PDPage page2 = new PDPage();
    doc.addPage(page2);
    PDPage page3 = new PDPage();
    doc.addPage(page3);

    PDFont font = PDType1Font.HELVETICA;
    float fontSize = 20;
    int xPos = 100;
    int yPos = 400;
    float titleWidth = font.getStringWidth("Tets") / 1000;
    float titleHeight = fontSize;
    float tx = titleWidth / 2;
    float ty = titleHeight / 2;

    try (PDPageContentStream contentStream = new PDPageContentStream(doc, page1))
    {
        contentStream.beginText();

        contentStream.newLineAtOffset(xPos, yPos);

        contentStream.setFont(font, fontSize);
        contentStream.showText("Tets");
        contentStream.endText();
    }

    // classic case of rotated page
    try (PDPageContentStream contentStream = new PDPageContentStream(doc, page2))
    {
        contentStream.beginText();

        Matrix matrix = Matrix.getRotateInstance(Math.toRadians(90), 0, 0);
        matrix.translate(0, -page2.getMediaBox().getWidth());

        contentStream.setTextMatrix(matrix);

        contentStream.newLineAtOffset(xPos, yPos);

        contentStream.setFont(font, fontSize);
        contentStream.showText("Tets");
        contentStream.endText();
    }

    // rotation around text
    try (PDPageContentStream contentStream = new PDPageContentStream(doc, page3))
    {
        contentStream.beginText();

        Matrix matrix = Matrix.getRotateInstance(Math.toRadians(90), 0, 0);
        matrix.translate(0, -page3.getMediaBox().getWidth());

        contentStream.setTextMatrix(matrix);

        contentStream.newLineAtOffset(yPos - titleWidth / 2 - fontSize, page3.getMediaBox().getWidth() - xPos - titleWidth / 2 - fontSize);

        contentStream.setFont(font, fontSize);
        contentStream.showText("Tets");
        contentStream.endText();
    }
    doc.save("saved.pdf");
    doc.close();
}