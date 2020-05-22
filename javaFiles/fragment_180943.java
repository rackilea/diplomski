public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    AffineTransform transform = AffineTransform.getRotateInstance(Math.PI / 6);
    stamper.getWriter().setPageEvent(new AddAnnotation(stamper, transform));
    PdfContentByte canvas = stamper.getOverContent(1);
    Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
    Chunk chunk = new Chunk("The Best iText Questions on StackOverflow", bold);
    chunk.setGenericTag("http://pages.itextpdf.com/ebook-stackoverflow-questions.html");
    Phrase p = new Phrase("Download ");
    p.add(chunk);
    p.add(" and discover more than 200 questions and answers.");
    canvas.saveState();
    canvas.concatCTM(transform);
    ColumnText ct = new ColumnText(canvas);
    ct.setSimpleColumn(300, 0, 800, 400);
    ct.addText(p);
    ct.go();
    canvas.restoreState();
    stamper.close();
    reader.close();
}