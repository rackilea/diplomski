void addSimpleTransparentPatternToOverContent(File source, File target) throws IOException, DocumentException
{
    PdfReader reader = new PdfReader(source.getPath());
    OutputStream os = new FileOutputStream(target);
    PdfStamper stamper = new PdfStamper(reader, os);

    PdfPatternPainter painter = stamper.getOverContent(1).createPattern(200, 150);
    painter.setColorFill(BaseColor.GREEN);
    painter.beginText();
    painter.setTextMatrix(AffineTransform.getTranslateInstance(0, 50));
    painter.setFontAndSize(BaseFont.createFont(), 100);
    painter.showText("Test");
    painter.endText();

    PdfGState state = new PdfGState();
    state.setFillOpacity(0.5f);

    for (int i = reader.getNumberOfPages(); i > 0; i--)
    {
        PdfContentByte overContent = stamper.getOverContent(i);

        overContent.setGState(state);
        overContent.setColorFill(new PatternColor(painter));
        overContent.rectangle(200, 300, 200, 150);
        overContent.fill();
    }

    stamper.close();
    os.close();
}