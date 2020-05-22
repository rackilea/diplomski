Pattern regex = Pattern.compile(
    "\\b     # word boundary\n" +
    "[A-Za-z]# 1 ASCII letter\n" +
    "\\w*    # 0+ alnums\n" +
    "\\b     # word boundary\n" +
    "(?!     # Lookahead assertion: Make sure there is no...\n" +
    " \\s*   # optional whitespace\n" +
    " \\(    # opening parenthesis\n" +
    ")       # ...at this position in the string", 
    Pattern.COMMENTS);