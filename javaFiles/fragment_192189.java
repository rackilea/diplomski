String value = "\"one\",\"two\",\"three\"";
Matcher m = Pattern.compile("\"((?:\\\\.|[^\"\\\\])*)\"").matcher(value);
while(m.find())
{
    System.out.println(m.group(1));
}