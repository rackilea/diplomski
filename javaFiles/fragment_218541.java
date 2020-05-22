Scanner s = new Scanner("-123456abcd9876az45678");
Pattern num = Pattern.compile("[+-]?\\d+");
Pattern letters = Pattern.compile("[A-Za-z]+");
System.out.println(s.findWithinHorizon(num, 0));
String str;
while ((str = s.findWithinHorizon(letters, 0)) != null) {
    System.out.println(str);
    System.out.println(s.findWithinHorizon(num, 0));
}