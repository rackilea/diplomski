public void printImageLocations(InputStream stream) throws IOException
{
    PdfReader reader = new PdfReader(stream);
    PdfReaderContentParser parser = new PdfReaderContentParser(reader);
    ImageRenderListener listener = new ImageRenderListener();

    for (int page = 1; page <= reader.getNumberOfPages(); page++)
    {
        System.out.printf("\nPage %s:\n", page);
        parser.processContent(page, listener);
    }
}

static class ImageRenderListener implements RenderListener
{
    public void beginTextBlock() { }
    public void renderText(TextRenderInfo renderInfo) { }
    public void endTextBlock() { }

    public void renderImage(ImageRenderInfo renderInfo)
    {
        try
        {
            PdfDictionary imageDict = renderInfo.getImage().getDictionary();

            float widthPx = imageDict.getAsNumber(PdfName.WIDTH).floatValue(); 
            float heightPx = imageDict.getAsNumber(PdfName.HEIGHT).floatValue();
            float widthUu = renderInfo.getImageCTM().get(Matrix.I11);
            float heigthUu = renderInfo.getImageCTM().get(Matrix.I22);

            System.out.printf("Image %.0fpx*%.0fpx, %.0fuu*%.0fuu, %.2fin*%.2fin\n", widthPx, heightPx, widthUu, heigthUu, widthUu/72, heigthUu/72);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}