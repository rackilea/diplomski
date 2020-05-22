List<Double> list = new ArrayList<>();
for(Row row : sheet){
    if(row.getRowNum() == 0)
        continue;
    Cell srs = row.getCell(7);
    list.add(src.getNumericCellValue());
}