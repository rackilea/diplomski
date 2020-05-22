Pattern p = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");

Matcher m = null;
String line = reader.readLine();
if (line != null && (m = p.matcher(line)).find()) {
    stringArray.add(line);
}

while ((line = reader.readLine()) != null) {
  m.reset(line);
  if (m.find()) {
    stringArray.add(line);
  }
}