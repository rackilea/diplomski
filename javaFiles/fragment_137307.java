String input = "\"This is a string\"\r\n\t\t";

String output = StringEscapeUtils.unescapeJava(input);

System.out.println(output);

"This is a string"