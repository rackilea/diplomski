List<DataSet> myList;
DataSet row;

Iterator it = values.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry pair = (Map.Entry)it.next();

    row.val1 = pair.getKey();
    row.val2 = pair.getValue();
    myList.add(row);
    it.remove();
}