String line = "Ahis order was placed for QT3000! OK?";
String pattern = "(?i)[aeiou]";

Pattern r = Pattern.compile(pattern);

Matcher m = r.matcher(line);

while (m.find()) {
   System.out.println(m.group(0) );
}