public static void main(String[] args) {
      String test = "http://www.something.com/{tag1}/path/{tag2}/else/{tag3}.html";
      String regex = "\\{.*?\\}";

      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(test);

      while (matcher.find()) {
         System.out.println(matcher.group());
      }
   }