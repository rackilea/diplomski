rep = new JacksonRepresentation<MyBean[]>(MediaType.TEXT_CSV, tab) {
    @Override
    protected ObjectWriter createObjectWriter() {
        CsvMapper csvMapper = (CsvMapper) getObjectMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(MyBean.class);
        ObjectWriter result = csvMapper.writer(csvSchema);
        return result;
    }
};