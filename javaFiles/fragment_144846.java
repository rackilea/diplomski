CsvParserSettings settings = new CsvParserSettings(); //many options here, check the tutorial
    settings.getFormat().setLineSeparator("\r\n");
    settings.getFormat().setNormalizedNewline('\u0001'); //uses a special character to represent a new record instead of \n.
    settings.setNormalizeLineEndingsWithinQuotes(false); //does not replace \r\n by the normalized new line when reading quoted values.
    settings.setHeaderExtractionEnabled(true); //extract headers from file
    settings.trimValues(false); //does not remove whitespaces around values 
    CsvParser parser = new CsvParser(settings);

    List<Record> recordsList = parser.parseAllRecords(new File("201404051539.csv"));