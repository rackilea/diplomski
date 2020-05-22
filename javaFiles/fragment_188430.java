String input = "2m0s";
SimpleDateFormat parseFormat = new SimpleDateFormat("mm'm'ss's'");
Date date = parseFormat.parse(input);
SimpleDateFormat displayFormat = new SimpleDateFormat("mm:ss");
String output = displayFormat.format(date);
System.out.println(input + " -> " + output);