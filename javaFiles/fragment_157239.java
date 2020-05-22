String regFlagMulti = "(\\[(\\w*?)=(.*?)\\])";
String flagMulti = "[TestFlag=1000][TestFlagSecond=1000]";
Matcher mFlagMulti = Pattern.compile(regFlagMulti).matcher(flagMulti);

while (mFlagMulti.find()) {
    System.out.println("String: " + mFlagMulti.group(1));
    System.out.println("   key: " + mFlagMulti.group(2));
    System.out.println("   val: " + mFlagMulti.group(3));
    System.out.println();
}