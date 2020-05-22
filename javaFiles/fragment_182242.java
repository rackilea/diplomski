List<Section> sections = new ArrayList<Section>();
String temp = null;
String line = null;
int lineNumber = 0;

while ((line = br.readLine()) != null) {
  lineNumber++;
  if (lineNumber % 2 == 0) {
    // Section Text
    sections.add(new Section(temp, line);
  }
  else {
    // Section Name
    temp = line;
  }
}