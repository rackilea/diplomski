String input = ... ;
Matcher m = Pattern.compile(
          "(\\w+\\s)?(\"[^\"]+\"|\\w+)(\\(\\w\\d(,\\w\\d)*\\))?").matcher(input);
while(matcher.find()) {
    System.out.println(matcher.group());
}