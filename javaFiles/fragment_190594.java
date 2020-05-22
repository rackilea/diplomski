String str = "125*1/4*4+82*1*10+2/59-2+4";
String regex = "[^\\d]";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(str);

while (matcher.find()) {                                                
    System.out.println(matcher.group());
}