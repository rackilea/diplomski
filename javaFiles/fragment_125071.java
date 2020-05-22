@Test
public void parses_csv_to_object_list() throws Exception {
    String csv = "id,name\n1,Red\n2,Green\n3,Blue";
    CsvMapper mapper = new CsvMapper();
    CsvSchema schema = mapper.schemaFor(ColourData.class).withHeader();
    ObjectReader reader = mapper.readerFor(ColourData.class).with(schema);
    try (MappingIterator<ColourData> iter = reader.readValues(csv)) {
        assertThat(iter.readAll(),
                contains(new ColourData(1, "Red"), new ColourData(2, "Green"), new ColourData(3, "Blue")));
    }
}

@Test
public void parses_csv_to_object_list_in_one_read() throws Exception {
    String csv = "id,name\n1,Red\n2,Green\n3,Blue";
    CsvMapper mapper = new CsvMapper().enable(CsvParser.Feature.WRAP_AS_ARRAY);
    CsvSchema schema = mapper.schemaFor(ColourData.class).withHeader();
    ObjectReader reader = mapper.readerFor(new TypeReference<List<ColourData>>() {
    }).with(schema);
    assertThat(reader.readValue(csv),
            contains(new ColourData(1, "Red"), new ColourData(2, "Green"), new ColourData(3, "Blue")));
}