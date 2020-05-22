String s = "Example - 123";
Matcher m = Pattern.compile("\\d+").matcher(s);
while(m.find())
{
        int num = Integer.parseInt(m.group());
        System.out.println(num);
}