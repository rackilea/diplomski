List<List<String>> listOfLists = new ArrayList<List<String>>();
...
while (rs.next()) {
    List<String> list = new ArrayList<String>();
    for (int i = 1; i < columns; i++) {
        list.add(rs.getString(i));
    }
    listOfLists.add(list);
}