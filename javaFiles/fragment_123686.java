String pattern = "^(<filename=)(\".*\")\\s(location=)(\".*\")\\s(extension=)(\".*\">)$";
String input = "<filename=\"\" location=\"\" extension=\"\">";
// you can uncomment this next line to test the case when values be
// already present in the input line
//String input = "<filename=\"stuff\" location=\"stuff\" extension=\"stuff\">";
System.out.println("Input string:");
System.out.println(input);

// you can replace these next 3 variables with whatever values you want
// e.g. you could put this code into a loop
String fileName = "FileName";           // a new filename
String location = "Location";           // a new location
String extension = "txt";               // a new extension
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(input);
if (m.find()) {
    StringBuilder res = new StringBuilder();
    res.append(m.group(1)).append("\"").append(fileName).append("\" ");
    res.append(m.group(3)).append("\"").append(location).append("\" ");
    res.append(m.group(5)).append("\"").append(extension).append("\">");
    System.out.println("Output string:");
    System.out.println(res);
} else {
    System.out.println("NO MATCH");
}