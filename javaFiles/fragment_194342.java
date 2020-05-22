public void recompressXRef(String src, String dest)
    throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    stamper.getWriter().setFullCompression();
    stamper.close();
    reader.close();
}