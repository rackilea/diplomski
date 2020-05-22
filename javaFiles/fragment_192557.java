File excel = null;
FileInputStream file = null;

try {
    excel = new File(dir + "\\" + filename + ".xls");
    file = new FileInputStream(excel);

    Workbook workbook = WorkbookFactory.create(file);
    Sheet sheet = workbook.getSheetAt(0);
    Iterator<Row> rowIterator = sheet.iterator();

    while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            // Cell data logic
        }
    }
} catch (FileNotFoundException fn) {
    fail(fn.getMessage());
} catch (IOException ioe) {
    ioe.printStackTrace();
} finally {
    file.close();
}