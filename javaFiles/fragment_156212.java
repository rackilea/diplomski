public static PdfPTable createFirstTable() {
    // a table with three columns
    PdfPTable table = new PdfPTable(3);

    // the cell object
    PdfPCell cell;
    // we add a cell with colspan 3
    //create header cell for first row
    PdfPHeaderCell headerCell = new PdfPHeaderCell();
    headerCell.setScope(PdfPHeaderCell.ROW);
    headerCell.setPhrase(new Phrase("Cell with colspan 3"));
    headerCell.setName("header Cell");
    headerCell.setAccessibleAttribute(PdfName.TD, new PdfString("Cell 1"));
    headerCell.setColspan(3);
    table.addCell(headerCell);
    // now we add a cell with rowspan 2
    cell = new PdfPCell(new Phrase("Cell with rowspan 2"));

    //add metadata for each cell in the body.
    cell.addHeader(headerCell);

    cell.setRowspan(2);
    table.addCell(cell);
    // we add the four remaining cells with addCell()
    table.addCell("row 1; caa*");
    table.addCell("row 1; c+");
    table.addCell("row 2; c-");
    table.addCell("row 2; c/");

    //set header row for the table
    table.setHeaderRows(1);

    return table;
}