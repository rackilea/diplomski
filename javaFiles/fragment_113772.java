List<TableFieldSchema> fields = new ArrayList<>();
TableFieldSchema column = new TableFieldSchema().setName("rawFields");
column.setType("RECORD");
List<TableFieldSchema> list = new ArrayList<>();
list.add(new TableFieldSchema().setName("key").setType("STRING"));
list.add(new TableFieldSchema().setName("value").setType("STRING"));
column.setFields(list);
column.setMode("REPEATED");
fields.add(column);
TableSchema schema = new TableSchema().setFields(fields);

TableRow row = new TableRow();
List<TableRow> rawFields = new ArrayList<>();
rawFields.add(new TableRow().set("key","foo").set("value", "bar"));
row.set("rawFields", rawFields);

Pipeline p = Pipeline.create(options);
PCollection<TableRow> c =
    p.apply(Create.of(row, row).withCoder(TableRowJsonCoder.of()));
c.apply(BigQueryIO.Write.named("BigQuery-Write")
        .to(options.getOutput())
        .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
        .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_TRUNCATE)
        .withSchema(schema));
p.run();