String pattern  = "(?m)\\s*\\w+\\s+\\w+\\s+(.+$)"; 
String line = "AAA BBB  CCCCC CCCCCCC\n  AAA              BBB  DDDD DDDD DDDDD\n    EEE         FFF  GGGGG GGGGG";

Pattern r = Pattern.compile(pattern);

Matcher m = r.matcher(line);
while (m.find()) {
     System.out.println("Found value: " + m.group(1) );
}