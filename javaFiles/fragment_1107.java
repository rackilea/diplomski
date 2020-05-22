public void extractText(String src, String dest) throws IOException
{
    PrintWriter out = new PrintWriter(new FileOutputStream(dest));
    PdfReader reader = new PdfReader(src);
    RenderListener listener = new MyTextRenderListener(out);
    PdfContentStreamProcessor processor = new PdfContentStreamProcessor(listener);
    PdfDictionary pageDic = reader.getPageN(1);
    PdfDictionary resourcesDic = pageDic.getAsDict(PdfName.RESOURCES);
    processor.processContent(ContentByteUtils.getContentBytesForPage(reader, 1), resourcesDic);
    out.flush();
    out.close();
}