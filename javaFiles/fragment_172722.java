Pattern pat = Pattern.compile("[:?!@#$%^&*()]");
String  str = "SUGAR :::: SUGAR";
Matcher m = pat.matcher(str);
if (m.find()) {
    System.out.println("string contains pattern");
}