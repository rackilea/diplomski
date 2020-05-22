// Locate the substring between "ORIGIN" and "//" in the file.
String fileContents = getSampleFileContents();
int indexOfOrigin = fileContents.indexOf("ORIGIN");
String pertinentSection = fileContents.substring(
    indexOfOrigin, fileContents.indexOf("//", indexOfOrigin));

// Search for sequences within the pertinent substring.
Pattern p = Pattern.compile("\\b([GCATgcat]+)\\b");
Matcher m = p.matcher(pertinentSection);
List<String> sequences = new ArrayList<String>();
while (m.find()) {
  sequences.add(m.group(1));
}
sequences.toString(); // => ["acagatgaag", "acagatgaag", ..., "acagatgaag"]