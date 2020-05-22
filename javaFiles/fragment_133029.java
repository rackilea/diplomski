Sheet sheet = wb.getSheetAt(0);
for (Row row : sheet) {
    for (int i = 0; i < 20; i++) {
        Cell cell = row.getCell(i);
    }
}