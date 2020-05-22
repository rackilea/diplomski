//                           | escaped opening bracket
//                           |  | any character, 0+ times
//                           |  |   | closing bracket
//                           |  |   |   | dot will also match new lines
Pattern p = Pattern.compile("\\{.*?}", Pattern.DOTALL);
Matcher m = p.matcher(DATA);
while (m.find()) {
    System.out.println(m.group());
}