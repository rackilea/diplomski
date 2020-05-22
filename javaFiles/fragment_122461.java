int count = 0;
int columnNum = 3;
for (Row row : sheet) {
    if (row.getCell(columnNum) != null) {
        count += 1;
    }
}