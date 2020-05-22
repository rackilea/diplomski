String str = "...";  // initialize

Pattern mPattern = Pattern.compile("(?x)" +  // Ignore whitespace
                        "(?:            " +  // Non-capturing group
                        "   .*?         " +    // 0 or more repetition of any character
                        "   (FFF1|FFF3) " +    // FFF1 or FFF3
                        "){4,}          "    // Group close. Match group 4 or more times
                                  );  

Matcher matcher = mPattern.matcher(str);        
System.out.println(matcher.find());