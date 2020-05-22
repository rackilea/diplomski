try (   PdfWriter writer = new PdfWriter(RESULT_STREAM_OR_FILE);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document doc = new Document(pdfDocument)   )
{
    Table table = new Table(new float[] {30, 30, 30, 30, 30, 30, 30, 30, 30});

    for (int i = 0; i < 4; i++) {
        table.addCell(new Cell(2, 1).add(new Paragraph("Text")));
        table.addCell(new Cell(2, 1).add(new Paragraph("Text")));
        table.addCell(new Cell().setHeight(15));
        table.addCell(new Cell(2, 1).add(new Paragraph("Text")));
        table.addCell(new Cell().setHeight(15));
        table.addCell(new Cell(2, 1).add(new Paragraph("Text")));
        table.addCell(new Cell().setHeight(15));
        table.addCell(new Cell(2, 1).add(new Paragraph("Text")));
        table.addCell(new Cell().setHeight(15));

        table.addCell(new Cell().setHeight(15));
        table.addCell(new Cell().setHeight(15));
        table.addCell(new Cell().setHeight(15));
        table.addCell(new Cell().setHeight(15));
    }

    doc.add(table);
    doc.close();
}