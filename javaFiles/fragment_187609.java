String sRegex="(?<=\\[)[^]]*(?=\\])";
Pattern p = Pattern.compile(sRegex); // create the pattern only once,
Matcher m = p.matcher(sFormula);
while (m.find()) {
   System.out.println( m.group() );
}