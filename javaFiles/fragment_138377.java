CSVParser parser = new CSVParserBuilder()
        .withSeparator(',')
        .withQuoteChar('"')
        .withIgnoreQuotations(true)
        .build();
CSVReader reader = new CSVReaderBuilder(new FileReader("tmdb_5000_credits.csv"))
        .withSkipLines(1)
        .withCSVParser(parser)
        .build();