PdfPTable table = new PdfPTable(2);
PdfPTable nestedTable1 = new PdfPTable(1);
PdfPTable nestedTable2 = new PdfPTable(1);

PdfPCell cell = new PdfPCell(new Phrase("StackOverflow"));
newCell.setBorder(Rectangle.NO_BORDER);

nestedTable1.addCell(cell);
nestedTable2.addCell(new Phrase("StackOverflow"));

cellOne = new PdfPCell(nestedTable1);
cellTwo = new PdfPCell(nestedTable2);

cellOne.setBorder(Rectangle.NO_BORDER);

table.addCell(cellOne);
table.addCell(cellTwo);