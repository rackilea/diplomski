Map<String, Integer> colPositions = rows.stream()
    .flatMap(m -> m.entrySet().stream())
    .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().size(),
                              Integer::max, TreeMap::new));
String[] header = colPositions.entrySet().stream()
    .flatMap(e -> Collections.nCopies(e.getValue(), e.getKey()).stream())
    .toArray(String[]::new);
int tableWidth = 0;
for(Map.Entry<String,Integer> e: colPositions.entrySet())
    tableWidth += e.setValue(tableWidth);

String[][] array = new String[rows.size()+1][tableWidth];
array[0] = header;

int rowIdx = 1;
for(Map<String, List<String>> row: rows) {
    for(Map.Entry<String,List<String>> e: row.entrySet()) {
        int index = colPositions.get(e.getKey());
        for(String s: e.getValue()) array[rowIdx][index++]=s;
    }
    rowIdx++;
}
return array;