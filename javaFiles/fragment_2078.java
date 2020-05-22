String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
   String QUOTE_PATTERN = 
   String.format(WITH_DELIMITER, "(?<!\\\\)\".{0,200}(?<!\\\\)\"");

   String input = "Example with \"quoted \\\"test\\\" region\" embedded";
   String[] result = input.split(QUOTE_PATTERN);
   System.out.println(Arrays.toString(result));