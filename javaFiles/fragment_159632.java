public String generateJsonFromCSV() throws IOException {
        File csvFile = new File("path/to/csv/mycsv.csv");
        File schemaJson = new File("path/to/json/schema.json");
        Map<String, CsvSchema.ColumnType> map = getSchemaMapFromJson(schemaJson);
        CsvSchema.Builder schemaBuilder = new CsvSchema.Builder();
        map.forEach(schemaBuilder::addColumn);
        CsvSchema schema = schemaBuilder.build();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Map<?, ?>> mappingIterator = csvMapper.readerFor(Map.class).with(schema).readValues(csvFile);
        String json = new ObjectMapper().writeValueAsString(mappingIterator.readAll());
        return json;
    }

    //Convert your JsonSchema to Map<String,CsvSchema.ColumnType>
    private Map<String, CsvSchema.ColumnType> getSchemaMapFromJson(File file) {
        return new HashMap<>();
    }