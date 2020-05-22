CsvParserSettings settings = new CsvParserSettings();
settings.detectFormatAutomatically();

CsvParser parser = new CsvParser(settings);
List<String[]> rows = parser.parseAll(new File("/path/to/your.csv"));

// if you want to see what it detected
CsvFormat format = parser.getDetectedFormat();