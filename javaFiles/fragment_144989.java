private <T> void test(Sheet sheet, HashMap<String, List<T>> map) {
    for (String var : map.keySet()) {
        List<T> list = map.get(var);
        for (int i = 0; i < list.size(); i++) {
            row = sheet.getRow(i);
            cell = row.createCell(currColumn);
            cell.setCellValue(list.get(i));
        }
        currColumn++;
    }
}