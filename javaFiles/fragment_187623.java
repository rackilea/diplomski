Reader reader = new FileReader("input.csv");
final CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
try {
    for (final CSVRecord record : parser) {
        final String string = record.get("SomeColumn");
        ...
    }
} finally {
    parser.close();
    reader.close();
}