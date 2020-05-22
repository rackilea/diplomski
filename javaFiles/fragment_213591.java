//Create the table which will be 2 Columns wide and make it 100% of the page
PdfPTable myTable = new PdfPtable(2);
myTable.setWidthPercentage(100.0f);

//create a 3 cells and add them to the table
PdfPCell cellOne = new PdfPCell(new Paragraph("Hello World"));
PdfPCell cellTwo = new PdfPCell(new Paragraph("Bottom Left"));
PdfPcell cellThree = new PdfPCell(new Paragraph("Bottom Right"));

cellOne.setColspan(2);
cellOne.setBorder(Rectangle.BOTTOM);
cellOne.setHorizontalAlignment(Element.ALIGN_LEFT);

cellTwo.setBorder(Rectangle.NO_BORDER);
cellTwo.setHorizontalAlignment(Element.ALIGN_LEFT);
cellThree.setBorder(Rectangle.LEFT);
cellThree.setHorizontalAlignment(Element.ALIGN_RIGHT);

//Add the three cells to the table
myTable.addCell(cellOne);
myTable.addCell(cellTwo);
myTable.addCell(cellThree);

//Do something to add the table to your root document