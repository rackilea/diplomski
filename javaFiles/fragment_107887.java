String line = "(rate:real;interest,principal:real)";
String pattern = "((?<=[\\(,;])[A-Za-z_]\\w*)";

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(line);

while (m.find()) {
    System.out.println(m.group(1));
}