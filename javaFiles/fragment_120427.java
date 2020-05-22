Pattern pattern = Pattern.compile("numFound=\"([0-9]+)\"");
Matcher matcher = pattern.matcher("<result name=\"response\" numFound=\"99999\" start=\"0\">");

if (matcher.find())
{
    System.out.println(matcher.group(1));
}