String fileContentsAsString = "ii ... bet ... you, ibetyouyou";
String regex = "i(?>(?!i|bet).)*+bet(?>(?!you).)*+you";
Pattern p = Pattern.compile(regex, Pattern.DOTALL);
Matcher m = p.matcher(fileContentsAsString);
while (m.find()) {
    System.out.println(m.group());
}