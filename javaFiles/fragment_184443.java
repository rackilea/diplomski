String search = "on a daily basis";
String toMatch = "to on a daily basis. ";
Pattern pattern = Pattern.compile("[^a-zA-Z]+(?<match>" + Pattern.quote(search) + ")[^a-zA-Z]+");

Matcher matcher = pattern.matcher(toMatch);

if (matcher.find()) {
  System.out.println(matcher.group().length());
  System.out.println(matcher.start());
  System.out.println(matcher.end());

  System.out.println(matcher.group("match").length());
  System.out.println(matcher.start("match")); // your expected result
  System.out.println(matcher.end("match")); 
}