String s = "HFGFHFFHSSH";  
final Pattern pattern = Pattern.compile("(?=(H[^H]*H))");
Matcher matcher = pattern.matcher(s);

while (matcher.find()) {
   System.out.println(matcher.group(1));
}