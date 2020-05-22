SessionFactoryImplementor sessionFactory = (SessionFactoryImplementor) ((Session) this.em.getDelegate()).getSessionFactory();

// Find all mapped tables with all mapped columns
final Map<String, Set<String>> tableColumns = new HashMap<>();

for (ClassMetadata metadata : sessionFactory.getAllClassMetadata().values()) {
  AbstractEntityPersister persister = (AbstractEntityPersister) metadata;
  Set<String> columns = new HashSet<>();
  tableColumns.put(persister.getTableName(), columns);
  for (String propertyName : persister.getPropertyNames()) {
    for (String propertyColumnName : persister.getPropertyColumnNames(propertyName)) {
      columns.add(propertyColumnName);
    }
  }
}

for (CollectionMetadata metadata : sessionFactory.getAllCollectionMetadata().values()) {
  AbstractCollectionPersister persister = (AbstractCollectionPersister) metadata;
  // ... extract key, index and element columns from persister, similar to AbstractEntityPersister
}

// Compare columns with existing metadata
sessionFactory.getCurrentSession().doWork(new Work() {
  public void execute(Connection connection) throws SQLException {
    for (Map.Entry<String, Set<String>> entry : tableColumns.entrySet()) {
      String tableName = entry.getKey();
      ResultSet rs = connection.getMetaData().getColumns(null, null, tableName, null);
      try {
        while (rs.next()) {
          String columnName = resultSet.getString("COLUMN_NAME");
          if (!entry.getValue().remove(columnName)) {
            log.error("Column not mapped: {}.{}", tableName, columnName));
          }
        }
        if (!entry.getValue().isEmpty()) {
          log.error("Columns not defined: {}.{}", tableName, entry.getValue()));
        }
      } finally {
        rs.close();
      }
    }
  }
});