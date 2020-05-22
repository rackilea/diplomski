String resultString = subjectString.replaceAll(
    "(?x)     # Multiline regex:\n" +
    "m        # Match a literal m\n" +
    "(        # Match and capture in backreference no. 1\n" +
    " [a-d]   # One letter from the range a through d\n" +
    ")        # End of capturing group\n" +
    "$        # Assert position at the end of the string", \
    "$1q");   // replace with the contents of group no. 1 + q