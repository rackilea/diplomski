StringBuilder builder = new StringBuilder("test");
for (int i = 0; i < 100; i++)
    builder.append(" test");
String test = builder.toString();

try (   OutputStream pdfStream = new FileOutputStream(new File(RESULT_FOLDER, "ChangingMargins.pdf")))
{
    Document pdfDocument = new Document(PageSize.A4.rotate(), 0, 0, 0, 0);
    PdfWriter.getInstance(pdfDocument, pdfStream);
    pdfDocument.open();

    for (int m = 0; m < pdfDocument.getPageSize().getWidth() / 2; m += 100)
    {
        pdfDocument.setMargins(m, m, 100, 100);
        pdfDocument.newPage();
        pdfDocument.add(new Paragraph(test));
    }

    pdfDocument.close();
}