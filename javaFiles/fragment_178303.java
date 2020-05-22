//Create a one column table
PdfPTable t = new PdfPTable(1);

//Tell it to use 100% of the page's width
t.WidthPercentage = 100;

//Create two rows with different colors
t.addCell(CreateCell("Hello", BaseColor.BLUE));
t.addCell(CreateCell("World", BaseColor.YELLOW));

//Add table to document
document.add(t);