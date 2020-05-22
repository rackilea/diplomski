String line = "<MSG><KEY>name.extObject</KEY><PARAM><CHAR>Number</CHAR><CHAR>7015:188188</CHAR></PARAM></MSG>";
Pattern pattern = Pattern.compile("<CHAR>(.*?)<\\/CHAR>");
Matcher matcher = pattern.matcher(line);

String result = "";
while (matcher.find()) {
    result += matcher.group(1) + " ";
}
System.out.println(result); //Prints: Number 7015:188188