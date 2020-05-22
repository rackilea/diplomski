String trying = "75px;"; 
Pattern tryingPattern = Pattern.compile("(?<="+Pattern.quote(trying)+").*?(?=center)", Pattern.DOTALL);
Matcher matcher = tryingPattern.matcher(str);
// check all instances
while (matcher.find()) {
  System.out.println(matcher.group());
}