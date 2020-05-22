Pattern regex = Pattern.compile(
    "([\"'])   # Match and remember a quote.\n" +
    "(?:       # Either match...\n" +
    " \\\\.    # an escaped character\n" +
    "|         # or\n" +
    " (?!\\1)  # (unless that character is identical to the matched quote char)\n" +
    " .        # any character\n" +
    ")*        # any number of times.\n" +
    "\\1       # Match the corresponding quote", 
    Pattern.COMMENTS);