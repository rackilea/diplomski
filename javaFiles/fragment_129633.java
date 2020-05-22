PdfPTable table = new PdfPTable(3);
PdfPCell cell13a = new PdfPCell(
    new Phrase("13"));
sectionII.addCell(cell13a);
PdfPCell cell13b = new PdfPCell(
    new Phrase("Last date and time of closing of online submission of application"));
sectionII.addCell(cell13b);
PdfPCell cell13c = new PdfPCell(
    new Phrase("(17:00 Hrs.) "));
cell13c.setHorizontalAlignment(Element.ALIGN_RIGHT);
sectionII.addCell(cell13c);