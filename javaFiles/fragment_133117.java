String pattern = "(?i)(?<=\\||^)[a-z]+@[0-9]+(?=\\||$)";
String str = "|ABC@123|abc@123456|ABcD@12";
Pattern p = Pattern.compile(pattern);
Matcher m = p.matcher(str);
while (m.find()) {
    System.out.println(m.group());
}