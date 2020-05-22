Matcher matcher = pattern.matcher(s);

   // Finds all the matches until found by moving the `matcher` forward
while(matcher.find()) {
    System.out.println(matcher.group());
}