public static void main(String[] args) throws FileNotFoundException, DocumentException {
    Document document = new Document();

    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("dest.pdf"));
    LogoHeaderFooter logoHeaderFooter = new LogoHeaderFooter();
    writer.setPageEvent(logoHeaderFooter);

    document.open();

    for (int i = 0; i < 3; ) {
        i++;
        document.add(new Paragraph("Paragraph " + i));
        document.newPage();
    }
    document.close();
}