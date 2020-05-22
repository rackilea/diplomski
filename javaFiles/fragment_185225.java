Schema timestampMilliType = LogicalTypes.timestampMillis().addToSchema(Schema.create(Schema.Type.LONG));

    Schema schemaWithTimestamp = SchemaBuilder
            .record("MyRecord").namespace("org.demo")
            .fields()
            .name("timestamp_with_logical_type").type(timestampMilliType).noDefault()
            .name("timestamp_no_logical_type").type().longType().noDefault()
            .endRecord();

    System.out.println(schemaWithTimestamp.toString(true));