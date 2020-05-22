String template = "<P ALIGN=\"LEFT\"><FONT FACE=\"Verdana\" SIZE=\"12\"> My Name is xyz </FONT></P>";
String pattern = "<FONT (.*?)>";

Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(template);

if (m.find()) {
    // prints: <FONT FACE="Verdana" SIZE="12"> My Name is xyz </FONT></P>
    System.out.println(m.group());

    // prints: FACE="Verdana" SIZE="12"
    System.out.println(m.group(1));
}