String datasetName = "test";
String tableName = "foo";
Table oldTable = bigQuery.getTable(datasetName, tableName);

Field col1 = Field.of("column_1", Field.Type.string());
Field col2 = Field.of("column_2", Field.Type.string());
Schema schema = Schema.of(col1, col2);
TableInfo tableInfo = oldTable.toBuilder().setDefinition(StandardTableDefinition.of(schema)).build();
bigQuery.update(tableInfo);