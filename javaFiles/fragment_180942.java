public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    PdfContentByte canvas = stamper.getOverContent(1);
    Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
    Chunk chunk = new Chunk("The Best iText Questions on StackOverflow", bold);
    chunk.setAnchor("http://pages.itextpdf.com/ebook-stackoverflow-questions.html");
    Phrase p = new Phrase("Download ");
    p.add(chunk);
    p.add(" and discover more than 200 questions and answers.");
    ColumnText ct = new ColumnText(canvas);
    ct.setSimpleColumn(36, 700, 559, 750);
    ct.addText(p);
    ct.go();
    stamper.close();
    reader.close();
}