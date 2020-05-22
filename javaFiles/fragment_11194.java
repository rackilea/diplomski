Map<String, Integer> colWidths = rows.
        stream().
        flatMap(m -> m.entrySet().stream()).
        collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().size(), Integer::max));
int tableWidth = colWidths.values().stream().mapToInt(Integer::intValue).sum();
String[][] array = new String[rows.size()][tableWidth];

int rowIdx = 0;
for(TreeMap<String, List<String>> row: rows) {
    int cellIdx = 0;
    for(Map.Entry<String,Integer> e: colWidths.entrySet()) {
        String col = e.getKey();
        List<String> cells = row.get(col);
        int index = cellIdx;
        if(cells != null) for(String s: cells) array[rowIdx][index++]=s;
        cellIdx += colWidths.get(col);
    }
    rowIdx++;
}
return array;