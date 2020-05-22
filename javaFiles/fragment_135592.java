String[] splitArray = subjectString.split(
    "(?x),   # Verbose regex: Match a comma\n" +
    "(?!     # unless it's followed by...\n" +
    " [^(]*  # any number of characters except (\n" +
    " \\)    # and a )\n" +
    ")       # end of lookahead assertion");