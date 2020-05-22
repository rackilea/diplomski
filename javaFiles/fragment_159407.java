GetTableNames getTableNames = new GetTableNames();
try {
    Object o = JdbcUtils.extractDatabaseMetaData(dataSource, getTableNames);
    System.out.println(o);
} catch (MetaDataAccessException e) {
    System.out.println(e);
}