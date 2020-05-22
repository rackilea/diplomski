StringJoiner jsonString = new StringJoiner(",", "[", "]");
for(Row row: resultSet.all()) {
   String json = row.getString(0);
   jsonString.add(json);
}

return jsonString.toString();