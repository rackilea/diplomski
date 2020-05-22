public static void main(String[] args) throws IOException
     {
         String test = "[(xx)(KEYX)some text]";
         Pattern pattern = Pattern.compile("\\(KEY.*\\)");

         Matcher matcher = pattern.matcher(test);
         matcher.find();
         String s = matcher.group(0);
         String s1 = test.substring(matcher.end(), test.length() - 1);
         System.out.println("" + s + "   " + s1);

     }