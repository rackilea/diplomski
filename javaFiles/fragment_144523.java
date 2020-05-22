public static ParseResult parseFile(File csvFile) {
    Scanner scan = null;
    try {
        scan = new Scanner(csvFile);
    } catch (FileNotFoundException e) {
        ???
        // Do something about this exception.
        // Consider not catching it here, letting the caller deal with it.
    }
    final List<KeyValuePair> sanitized = new ArrayList<KeyValuePair>();
    final List<KeyValuePair> badKey = new ArrayList<KeyValuePair>();
    final List<KeyValuePair> badValue = new ArrayList<KeyValuePair>();
    while (scan.hasNext()) {
        String[] tokens = scan.nextLine().trim().split(",");
        if (tokens.length != 2) {
            ???
            // Do something about this - either throw an exception,
            // or log a message and continue.
        }
        KeyValuePair kvp = new KeyValuePair(tokens[0], tokens[1]);
        // Do the validation on the spot
        if (!validateRecordKey(kvp.getKey())) {
            badKey.add(kvp);
        } else if (!validateRecord(kvp.getValue())) {
            badValue.add(kvp);
        } else {
            sanitized.add(kvp);
        }
    }
    return new ParseResult(sanitized, badKey, badValue);
}