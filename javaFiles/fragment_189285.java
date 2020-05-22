String text = 
    "<td class=\"col_stat\">1</td>" + 
    "<td class=\"col_stat\">0</td>" + 
    "<td class=\"col_stat\">1</td>";
String filePattern = "<td class=\"col_stat\">(\\d+)</td>";
Pattern pattern = Pattern.compile(filePattern);
Matcher matcher = pattern.matcher(text);
while (matcher.find())
{
    String number = matcher.group(1);
    System.out.println(number);
}