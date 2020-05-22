String testdata = "HTTP/1.1 302 Found\r\nServer: Apache\r\n\r\n";
Matcher matcher = Pattern.compile("(?:\\bServer:\\s*)(.*?)(?=[\r\n]+)").matcher(testdata);
if (matcher.find())
{
    System.out.println(matcher.group(1));
}