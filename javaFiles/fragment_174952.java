// note: I have simplified your pattern a bit, you probably don't need all 
// those restrictions
Pattern pattern = Pattern.compile("\\$tag:.+?\\$");
Matcher matcher = pattern.matcher(body);
while (matcher.find()) {
    // TODO whatever you want with the matched group
    System.out.println(matcher.group());
}