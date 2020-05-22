String str=" abc d 1234567890pqr 54897";
Pattern pattern = Pattern.compile("\\w+([0-9]+)\\w+([0-9]+)");
Matcher matcher = pattern.matcher(str);
for(int i = 0 ; i < matcher.groupCount(); i++) {
  matcher.find();
  System.out.println(matcher.group());
}