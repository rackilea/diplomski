CsvParserSettings parserSettings = new CsvParserSettings(); //many options here, check the tutorial.
parserSettings.detectFormatAutomatically();

CsvParser parser = new CsvParser(parserSettings);

//parse and get the detected format
List<String[]> parsedRows = parser.parseAll(new File("/path/to/input.csv"));
CsvFormat detectedFormat = parser.getDetectedFormat();

//now, write using the detected format:
CsvWriterSettings writerSettings = new CsvWriterSettings();
writerSettings.setFormat(detectedFormat);

CsvWriter writer = new CsvWriter(new File("/path/to/output.csv"), writerSettings);
writer.writeStringRowsAndClose(parsedRows);