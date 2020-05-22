PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outFileName));
Document doc = new Document(pdfDoc);

Table table = new Table(UnitValue.createPercentArray(new float[]{30, 30}));
for (int i = 0; i < 40; i++) {
    table.addCell(new Cell().add(new Paragraph("Hello")));
    table.addCell(new Cell().add(new Paragraph("World")));
    table.startNewRow();
}
table.setNextRenderer(new CustomTableRenderer(table));
doc.add(table);