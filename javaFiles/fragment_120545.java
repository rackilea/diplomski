public static void main(String[] args) throws IOException
 {
     String test = "[(xx)(KEYXYYYYYY)some text]";
     Pattern pattern = Pattern.compile("(?<=\\()KEY.*(?=\\))");

     Matcher matcher = pattern.matcher(test);
     matcher.find();
     String s = matcher.group(0);
     String s1 = test.substring(matcher.end() + 1, test.length() - 1);
     System.out.println("" + s + "   " + s1);

 }