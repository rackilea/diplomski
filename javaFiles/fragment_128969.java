List<Integer> positions = new ArrayList();
Pattern p = Pattern.compile(queryPattern);  // insert your pattern here
Matcher m = p.matcher(documentText);
while (m.find()) {
   positions.add(m.start());
}