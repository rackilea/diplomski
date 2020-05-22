Schema jsonSchema = JsonUtil.inferSchema(fs.open(source), "RecordName", 20);
try (JSONFileReader<Record> reader = new JSONFileReader<>(
                    fs.open(source), jsonSchema, Record.class)) {

  reader.initialize();

  try (ParquetWriter<Record> writer = AvroParquetWriter
      .<Record>builder(outputPath)
      .withConf(new Configuration)
      .withCompressionCodec(CompressionCodecName.SNAPPY)
      .withSchema(jsonSchema)
      .build()) {
    for (Record record : reader) {
      writer.write(record);
    }
  }
}