Paragraph p = new Paragraph("Test");
PdfPTable table = new PdfPTable(2);
for (int i = 1; i < 6; i++) {
    table.addCell("key " + i);
    table.addCell("value " + i);
}
for (int i = 0; i < 40; i++) {
    document.add(p);
}
document.add(table);