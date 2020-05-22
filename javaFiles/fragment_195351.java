final String QUOTED_VALUE = "\"[^\"]*\""; // A double quote character, zero or more non-double quote characters, and another double quote
String regex = "^" +                           // The beginning of the string
               "(" + QUOTED_VALUE + ")" +      // Capture the first value
               "(," +                          // Start a group, a comma
                 "(" + QUOTED_VALUE + ")" +    // Capture the next value
               ")*" +                          // Close the group.  Allow zero or more of these
               "(." +                          // Start a group, any character
                 "(" + QUOTED_VALUE + ")" +      // Capture another value
                 "(," +                            // Started a nested group, a comma
                    "(" + QUOTED_VALUE + ")" +     // Capture the next value
                 ")" +                             // Close the nested group
               ")*" +                            // Close the group.  Allow zero or more
               ".$";                           // Any character, the end of the input