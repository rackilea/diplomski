String regex = "Windows(?=95|98|NT|2000)";
String str = "Windows2000";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(str);
while (m.find()) {
    System.out.println(m.group()); // prints "Windows"
}