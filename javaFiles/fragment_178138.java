String line = "12-512-2-15-487-9-98";
String pattern = "(\\d+-\\d+-\\d+)-(\\d+-\\d+-\\d+-\\d+)";


Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(line);

if (m.find( )) {
  System.out.println("Found value: " + m.group(0) );
  System.out.println("Found value: " + m.group(1) );
  System.out.println("Found value: " + m.group(2) );
} else {
  System.out.println("NO MATCH");
}