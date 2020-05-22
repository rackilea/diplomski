for (int j = 0; j < proList.size(); j++) {
    HashMap hashMap = proList.get(j);
    rows=sheet1.createRow(j+1);
    Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
    int col = 0;
    while (iterator.hasNext()) {
        Map.Entry<String, String> entry = iterator.next();       
        cc=rows.createCell(col++);
        cc.setCellValue(entry.getValue());
    }
}