final Pattern pattern = Pattern.compile("href=\"(.*+)\"");
Matcher matcher = pattern.matcher(html);
String link = null;
while (matcher.find())
{
    link = matcher.group(1);
    Log.i("my.regex", "Found link: " + link);
}