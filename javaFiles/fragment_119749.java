Pattern regex = Pattern.compile(
    "\\(                # Match (\n" +
    "(?=[^()]*\\b21\\b) # Assert that 21 can be matched within this group\n" +
    "(?=[^()]*\\b33\\b) # Assert that 33 can be matched within this group\n" +
    "\\d+               # Match a number    \n" +
    "(?:                # Start of non-capturing group:\n" +
    " \\|               #  Match |\n" +
    " \\d+              #  Match a number\n" +
    ")*                 # any number of times, including 0\n" +
    "\\)                # Match )", 
    Pattern.COMMENTS);