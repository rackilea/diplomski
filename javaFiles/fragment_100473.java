Map<String, List<String>> queryResults = new TreeMap<>();
while (resultSet.next()) {
    if (!queryResults.contains(resultSet.getString(1)) {
        queryResults.put(resultSet.getString(1), new ArrayList<>());
    }
    queryResults.get(resultSet.getString(1)).add(resultSet.getString(2));
}