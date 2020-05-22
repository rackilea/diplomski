//taken from the example
Sheet sheet = wb.getsheetat(0);
for (Iterator<Row> rit = sheet.rowiterator(); rit.hasnext(); ) {
    Row row = rit.next();
    //now, based in your needs
    Cell cell = row.getCell(column);
    //do what you need with the row-column
}