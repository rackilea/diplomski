String s="(Air Fresheners,17)->(Chocolate Chips,14)->(Juice-Frozen,24)";

Pattern regex = Pattern.compile("\\)->\\(");
Matcher regexMatcher = regex.matcher(s);
int i=0;
while (regexMatcher.find()) {
    System.out.println(s.substring(i+1,regexMatcher.start()));
    i=regexMatcher.end()-1;
}
System.out.println(s.substring(i+1,s.length()-1));