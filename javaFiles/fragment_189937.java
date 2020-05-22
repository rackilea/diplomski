// a table with three columns
    PdfPTable table = new PdfPTable(3);
    // the cell object
    PdfPCell cell;
    // we add a cell with colspan 3
    cell = new PdfPCell(new Phrase("Cell with colspan 3"));
    cell.setColspan(3);
    table.addCell(cell);
    // now we add a cell with rowspan 2
    cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
    cell.setRowspan(2);
    table.addCell(cell);
    // we add the four remaining cells with addCell()
    table.addCell("row 1; cell 1");
    table.addCell("row 1; cell 2");
    table.addCell("row 2; cell 1");
    table.addCell("row 2; cell 2");