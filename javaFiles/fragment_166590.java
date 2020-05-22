public String extract(String input, String cat)
{
    Pattern p = Pattern.compile(cat + "\\s*>\\s*([^\\|]+)");
    Matcher m = p.matcher(input);
    StringBuffer sb = new StringBuffer();
    while (m.find())
    {
        sb.append(" - ").append(m.group(1));
    }
    return sb.toString();
}