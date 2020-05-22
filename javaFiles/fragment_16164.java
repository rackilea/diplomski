Iterator<Map<String, String>> iter = allFieldValues.iterator();
Map<String, String> row;
for (int i = 0; i <= rowIndex; i++) {
    row = iter.next();
}

String col;
Iterator<String> iter2 = row.values().iterator();
for (int i = 0; i <= colIndex; i++) {
    col = iter2.next();
}