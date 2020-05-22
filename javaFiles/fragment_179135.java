// Blank Document
XWPFDocument document = new XWPFDocument();

// Write the Document in file system
FileOutputStream out = new FileOutputStream(new File("create_table.docx"));

// Create table
XWPFTable table = document.createTable();

// Table row
XWPFTableRow tableRow;

int rowCount = model.getRowCount() - 1;
int colCount = model.getColumnCount() - 1;

// Iterate through rows
for (int row = 0; row <= rowCount; row++) {
    tableRow = table.getRow(row);

    // Iterate through columns
    for (int col = 0; col <= colCount; col++) {
        tableRow.getCell(col).setText((String) model.getValueAt(row, col));

        // If more columns, add cell
        if (row == 0 && col < colCount) {
            tableRow.addNewTableCell();
        }
    }

    // If more rows, add row
    if (row < rowCount) {
        table.createRow();
    }
}

// Write to word document and close file.        
document.write(out);
out.close();