final String QUOTED_VALUE = "\"[^\"]*\""; // A double quote character, zero or more non-double quote characters, and another double quote
final String NEWLINE = "(\n|\n\r|\r\n)";  // A newline for (almost) any OS: Windows, *NIX or Mac
final String LINE = "(" + QUOTED_VALUE + ")" +   // Capture the first value
                    "(?:," +                       // Start a group, a comma
                      "(" + QUOTED_VALUE + ")" + // Capture the next value
                    ")*";                        // Close the group.  Allow zero or more of these
String regex = "^" +             // The beginning of the string
               LINE +            // Read the first line, capture its values
               "(?:" + NEWLINE + // Start a group for the remaining lines
                 LINE +            // Read more lines, capture their values
               ")*" +            // Close the group.  Allow zero or more
               NEWLINE + "$";    // A trailing newline, the end of the input