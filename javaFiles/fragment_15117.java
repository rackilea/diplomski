public void createPdf(String dest) throws IOException, DocumentException {
    Rectangle pagesize = PageSize.LETTER;
    Document document = new Document(pagesize);
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    PdfPTable table = new PdfPTable(2);
    PdfPCell cell;
    //Add rows with selectors
    PdfFormField selectGroup = PdfFormField.createEmpty(writer);
    selectGroup.setFieldName("myCombos");
    String[] options = {"Choose first option", "Choose second option", "Choose third option"};
    String[] exports = {"option1", "option2", "option3"};
    table.addCell("Combobox:");
    cell = new PdfPCell();
    cell.setCellEvent(new SelectCellEvent(selectGroup, "combo1", exports, options));
    cell.setMinimumHeight(20);
    table.addCell(cell);
    document.add(table);
    writer.addAnnotation(selectGroup);
    document.close();
}