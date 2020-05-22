public static void main (String[] args)
{
    String sample = "2016-02-06 10:19:36,410 INFO  [[RequestMappingHandlerMapping]]: I am an important log [123, 21] ...{.....}";

    int position = sample.indexOf("INFO");
    System.out.println("TimeStamp: " + sample.substring(0,position-1));

    Pattern MY_PATTERN = Pattern.compile("\\[[0-9, ]+\\]");
    Matcher m = MY_PATTERN.matcher(sample);
    while (m.find()) {
        String str = m.group(0);
        String[] s = str.substring(1,str.length()-2).split(", ");
        System.out.println("Id: " + s[0]);
        System.out.println("AnotherValueIWant: " + s[1]);
    }
}