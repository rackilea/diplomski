public static final String FONT = "resources/fonts/QUENCAP1.TTF";

public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(DEST));
    document.open();
    Font f1 = FontFactory.getFont(FONT, BaseFont.WINANSI, BaseFont.EMBEDDED, 12);
    document.add(new Paragraph("A Hello World PDF document.", f1));
    document.close();
}