Matcher m=Pattern.compile("\\{[^{}]*\\}").matcher(input);
while(m.find())
{
    input=m.replaceAll("");
    m.reset(input);
}