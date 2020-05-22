Pattern pattern = Pattern.compile("'\\d+', '(.*?)'");
Matcher matcher = pattern.matcher(onMouseOver);                
if(matcher.find()) {
  System.out.print(matcher.group(1));
}
else {
  System.out.print("no match");
}