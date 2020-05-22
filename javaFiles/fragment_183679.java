String test = "'abc,ab,123',,,'123,aa,abc',,,";
Pattern p = Pattern.compile("'[^']*'");//extract non overlapping string between single quotes
Matcher m = p.matcher(test);
while (m.find()) { //does the pattern exists in input (sub)string
  System.out.println(m.group());//print string that matches pattern
}