CsvParserSettings parserSettings = new CsvParserSettings(); //parser config with many options, check the tutorial
parserSettings.setHeaderExtractionEnabled(true); // uses the first row as headers

// To get the values of all columns, use a column processor
ColumnProcessor rowProcessor = new ColumnProcessor();
parserSettings.setRowProcessor(rowProcessor);

CsvParser parser = new CsvParser(parserSettings);

//This will parse everything and pass the data to the column processor
parser.parse(new FileReader(new File("/path/to/your/file.csv")));

//Finally, we can get the column values:
Map<String, List<String>> columnValues = rowProcessor.getColumnValuesAsMapOfNames();