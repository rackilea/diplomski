PdfPCell cell = new PdfPCell();
List<String> list = (List<String>) sessionMapGeneral.get("eventIdPdf");
for (String item : list) {
    cell.addElement(new Paragraph(item));
}
table.addCell(cell);