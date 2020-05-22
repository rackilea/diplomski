PdfPTable table = new PdfPTable(1);
table.setTotalWidth(523);
PdfPCell cell = new PdfPCell(new Phrase("This is a test document"));
cell.setBackgroundColor(BaseColor.ORANGE);
table.addCell(cell);
cell = new PdfPCell(new Phrase("This is a copyright notice"));
cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
table.addCell(cell);