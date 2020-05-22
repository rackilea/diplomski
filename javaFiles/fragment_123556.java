Map<CellKey, List<Integer>> cells = new HashMap<>();

// get value
cells.get(CellKey.at(row, column));

// put value
cells.put(CellKey.at(row, column), value);
cells.put(CellKey.at(row, column), Arrays.asList(int1, int2, int3));

// check if value exists
cells.contains(CellKey.at(row, column));

// iterate over all cells containing values
cells.entrySet().stream().forEach(e -> {
    String row = e.getKey().getRow();
    String column = e.getKey().getColumn();
    List<Integer> value = e.getValue();
    // make your actions
});

// iterate over given row
String row = "K";
String[] columns = new String[]{"A", "B", "C", "D"};
for (String c : columns) {
   List<Integer> values = cells.get(CellKey.at(row, c));
   // perform actions
}