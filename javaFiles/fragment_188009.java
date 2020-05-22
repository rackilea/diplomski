public static class TestRewriter extends PDFTextStripper
{
    final PDPageContentStream canvas;

    public TestRewriter(PDPageContentStream canvas) throws IOException
    {
        this.canvas = canvas;
    }

    /**
     * @param text
     *            The text to be processed
     */
    public void processTextPosition(TextPosition text)
    {
        try
        {
            PDFont font = PDType1Font.HELVETICA;
            canvas.setFont(font, 10);
            canvas.beginText();
            canvas.appendRawCommands("" + (text.getXDirAdj()) + " " + (400 - text.getYDirAdj()) + " Td");
            canvas.appendRawCommands("(" + text.getCharacter() + ")" + " Tj\n");
            canvas.endText();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}