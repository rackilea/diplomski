ICsvListReader listReader = null;
try {
    CsvPreference prefs = CsvPreference.STANDARD_PREFERENCE;
    listReader = new CsvListReader(
        new SkipBlankLinesTokenizer(new FileReader(CSV_FILENAME), prefs),
        prefs);
...