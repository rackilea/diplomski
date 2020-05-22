String str = "\\u003c";
Matcher m = Pattern.compile("(?i)\\\\u([\\da-f]{4})").matcher(str);
if (m.find()) {
    String a = String.valueOf((char) Integer.parseInt(m.group(1), 16));
    System.out.printf("Unicode String is: [%s]%n", a);
}