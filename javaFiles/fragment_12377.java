testTable = new PdfPTable(1);
PdfPCell c2;
testTable.addCell("aaaa");
testTable.addCell("bbbb");

c2 = new PdfPCell (testTable);//this line made the difference
c2.setPadding(0);
outerTable.addCell(c2);