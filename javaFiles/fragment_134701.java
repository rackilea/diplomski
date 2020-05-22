// Instantiate the BQ client
BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

// Get the table, schema and fields from the already-existing table
Table table = bigquery.getTable(TableId.of("PROJECT_ID", "DATASET", "TABLE"));
Schema schema = table.getDefinition().getSchema();
FieldList fields = schema.getFields();

// Create the new field
Field newField = Field.of("column2", LegacySQLTypeName.STRING);

// Create a new schema adding the current fields, plus the new one
List<Field> field_list = new ArrayList<Field>();
for (Field f : fields) {
    field_list.add(f);
}
field_list.add(newField);
Schema newSchema = Schema.of(field_list);

// Update the table with the new schema
Table updatedTable = table.toBuilder().setDefinition(StandardTableDefinition.of(newSchema)).build().update();