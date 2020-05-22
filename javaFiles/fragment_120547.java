public static void main(String[] args) throws IOException
 {
     String test = "[(xx)(time1.zone1)some text1]blahblahblah[(xx)(time2.zone2)some text2]";
     Pattern pattern = Pattern.compile("(?<=\\()[^xy].*?]");

     Matcher matcher = pattern.matcher(test);
     while(matcher.find())
     {
         String s = matcher.group(0);
         String s1 = s.substring((s.indexOf(")") + 1), (s.length() - 1));
         s = s.substring(0, s.indexOf(")"));
         System.out.println("" + s + "   " + s1);
     }

 }