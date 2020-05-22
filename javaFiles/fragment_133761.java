void invert(File source, File target) throws IOException, DocumentException
{
    PdfReader reader = new PdfReader(source.getPath());
    OutputStream os = new FileOutputStream(target);
    PdfStamper stamper = new PdfStamper(reader, os);
    invert(stamper);
    stamper.close();
    os.close();
}

void invert(PdfStamper stamper)
{
    for (int i = stamper.getReader().getNumberOfPages(); i>0; i--)
    {
        invertPage(stamper, i);
    }
}

void invertPage(PdfStamper stamper, int page)
{
    Rectangle rect = stamper.getReader().getPageSize(page);

    PdfContentByte cb = stamper.getOverContent(page);
    PdfGState gs = new PdfGState();
    gs.setBlendMode(PdfGState.BM_DIFFERENCE);
    cb.setGState(gs);
    cb.setColorFill(new GrayColor(1.0f));
    cb.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
    cb.fill();

    cb = stamper.getUnderContent(page);
    cb.setColorFill(new GrayColor(1.0f));
    cb.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
    cb.fill();
}