String cleanXMLString = null;
Pattern pattern = null;
Matcher matcher = null;
pattern = Pattern.compile("[\\000]*");
matcher = pattern.matcher(dirtyXMLString);
if (matcher.find()) {
   cleanXMLString = matcher.replaceAll("");
}