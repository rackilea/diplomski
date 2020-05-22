String sourceXML = readFileToString("source.xml")
final Pattern pattern = Pattern.compile(".*(<parameter>.+</parameter>).*",Pattern.DOTALL);
Matcher matcher = pattern.matcher(sourceXML);
if (matcher.find()) {
   String xmlToParse = matcher.group(0);
   someDomOrSaxParser.parseFromString(xmlToParse)
}else 
   System.out.println("NO MATCH");