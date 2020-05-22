String s = "XYZ Road 123 Suite";
Matcher m = Pattern.compile("(?i)(?=(\\b\\w+ Road \\d+\\b)|(\\b\\d+ suite))").matcher(s);
while(m.find())
{
    if(m.group(1) != null) System.out.println(m.group(1));
    if(m.group(2) != null) System.out.println(m.group(2));
}