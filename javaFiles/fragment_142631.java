List<List<Integer>> inputData = ...

Map<Integer, List<Integer>> dataAsMap = new HashMap<>();
for(List<Integer> row : data){
  Integer id = row.get(0);
  Integer item = row.get(1);
  List<Integer> rowInMap = dataAsMap.get(item);
  if (rowInMap == null) {
    rowInMap = new ArrayList<>(); 
    dataAsMap.put(item, rowInMap);
  }
  rowInMap.add(id);
}