String input = "column1,column2\r\n" +
               "1,Foo\r\n" +
               "\"2\",\"Bar\"\r\n";
CSVFormat csvFormat = CSVFormat.RFC4180.withFirstRecordAsHeader()
                                       .withIgnoreEmptyLines(true)
                                       .withTrim();
try (CSVParser records = csvFormat.parse(new StringReader(input))) {
    for (CSVRecord record : records) {
        String column1 = record.get("column1");
        String column2 = record.get("column2");
        System.out.println(column1 + ": "+ column2);
    }
}