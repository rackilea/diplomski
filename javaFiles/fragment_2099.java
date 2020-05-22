String test = "Time: Sun Apr 10 20:36:57 CEST 2011\nMessage: java.lang.NullPointerException\n   at com.hello.World.Hi.initDB(bla.java:273)";
Pattern check = Pattern.compile(".*Message:(\\s[\\w\\.]*)");
Matcher checker = check.matcher(test);
while(checker.find())
{
    System.out.println(checker.group(1));
}