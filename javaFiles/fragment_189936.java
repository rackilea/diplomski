Document document = new Document();
PdfPTable table = new PdfPTable(8); <-- This is a constructor. Above 8 cells, would automatically move to a new row.
PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
PdfPCell cell4 = new PdfPCell(new Paragraph("Cell 4"));
PdfPCell cell5 = new PdfPCell(new Paragraph("Cell 5"));
PdfPCell cell6 = new PdfPCell(new Paragraph("Cell 6"));
PdfPCell cell7 = new PdfPCell(new Paragraph("Cell 7"));
PdfPCell cell8 = new PdfPCell(new Paragraph("Cell 8"));

cell1 = new PdfPCell(new Paragraph("Cell 1"));
cell2 = new PdfPCell(new Paragraph("Cell 2"));
cell3 = new PdfPCell(new Paragraph("Cell 3"));
cell4 = new PdfPCell(new Paragraph("Cell 4"));
cell5 = new PdfPCell(new Paragraph("Cell 5"));
cell6 = new PdfPCell(new Paragraph("Cell 6"));
cell7 = new PdfPCell(new Paragraph("Cell 7"));
cell8 = new PdfPCell(new Paragraph("Cell 8"));
document.add(table);