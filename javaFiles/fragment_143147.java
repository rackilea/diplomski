List<Schema.Field> fields = new ArrayList<>();
    fields.add(new Schema.Field("lat", Schema.create(Schema.Type.DOUBLE)));
    fields.add(new Schema.Field("lon", Schema.create(Schema.Type.DOUBLE)));
    fields.add(new Schema.Field("props", Schema.createMap(
            Schema.createUnion(Arrays.asList(
                Schema.create(Schema.Type.INT),
                Schema.create(Schema.Type.STRING))))));

    Schema schema = Schema.createRecord("TimeDot", null, "TestAvroUnion", false, fields);

    TimeDot dot = new TimeDot();
    dot.lat = 12;
    dot.lon = 34;
    dot.putProperty("id", 1234);
    dot.putProperty("s", "foo");
    System.out.println("BEFORE: " + dot);

    // serialize
    ReflectDatumWriter<TimeDot> reflectDatumWriter = new ReflectDatumWriter<>(schema);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    DataFileWriter<TimeDot> dataWriter = new DataFileWriter<>(reflectDatumWriter);
    dataWriter.create(schema, out);
    dataWriter.append(dot);
    dataWriter.close();

    // deserialize
    ReflectDatumReader<TimeDot> reflectDatumReader = new ReflectDatumReader<>(schema);
    try(
        ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
        DataFileStream<TimeDot> reader = new DataFileStream<>(bis, reflectDatumReader)
    ) {
        TimeDot dot2 = reader.next();
        System.out.println("AFTER:  " + dot2);
    }
}