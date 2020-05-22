String input = "8th floor, Prince's Building, 12 Chater Road";
String regex = "([0-9A-Za-z])+(st|nd|rd|th)" + " " + "floor";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(input);
if (m.find()) {
    String num = m.group(1);
    String suffix = m.group(2);
    System.out.println("Welcome to the " + num + suffix + " floor!");
    // prints 'Welcome to the 8th floor!'
}