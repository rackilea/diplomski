String pattern = "\\w+|\\$\\w+\\$";

Pattern r = Pattern.compile(pattern);

Matcher m = r.matcher(testString);
while (m.find( )) {
   System.out.println("Found value: " + m.group(0) );
}