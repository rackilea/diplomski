private String generateRandomSQL(ReadTableConnectionInfo table) {
    Random r = new Random(table.getColumns.size());
    int rNumber = r.nextInt();

    List<String> suffledColumns = new ArrayList<String>(table.getColumns());
    Collections.shuffle(suffledColumns);

    String columnsList = "";

    for(int i = 0 ; i < rNumber ; i ++){
        columnsList += ("," + shuffledColumns.get(i));
    }

    final String sql = "SELECT ID, CREATION_DATE, LAST_MODIFIED_DATE" + columnsList +"  from " + table.getTableName() + " where id = ?";

        return sql;
}