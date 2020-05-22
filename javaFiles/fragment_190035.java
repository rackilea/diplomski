String input ="Monday pt23 Operating Mode";
Pattern p = Pattern.compile("Monday pt([0-9]+) Operating Mode");
Matcher m = p.matcher(input);
boolean found = m.find();
if (found) {
    String number = m.group(1);
    System.out.println(number);
}