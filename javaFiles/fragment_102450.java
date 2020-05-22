List<String> allMatches = new ArrayList<String>();
Pattern p = Pattern.compile("#[^*]+\\*");
Matcher m = p.matcher(yourString);
while (m.find()) {
   allMatches.add(m.group());
 }