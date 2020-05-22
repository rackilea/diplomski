// We want to read from the 2nd column onwards, zero based
int firstColumn = 1;

// Always fetch at least 4 columns
int MY_MINIMUM_COLUMN_COUNT = 5;
// Work out the last column to go to
int lastColumn = Math.max(r.getLastCellNum(), MY_MINIMUM_COLUMN_COUNT);

// To format cells into strings
DataFormatter df = new DataFormatter();

// Iterate over the cells
for (int cn = firstColumn; cn < lastColumn; cn++) {
    Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
    if (c == null) {
        // The spreadsheet is empty in this cell
    } else {
        // Do something useful with the cell's contents

        // eg get the cells value as a string
        String cellAsString = df.formatCellValue(c);
    }
}