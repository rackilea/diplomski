CsvWriter.CsvWriterDSL<String[]> dsl = CsvWriter.from(String[].class)
                                                .columns("a[0]", "a[1]", "a[2]")
                                                .skipHeaders();

try (FileWriter fileWriter = new FileWriter(file)) {
    CsvWriter<String[]> writer = dsl.to(fileWriter);
    lines.forEach(CheckedConsumer.toConsumer(writer::append));
}