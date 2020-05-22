CSVReader csvReader = new CSVReader(reader);
List<List<String>> rows = new ArrayList<>();
String[] nextRecord;
while ((nextRecord = csvReader.readNext()) != null) {
  rows.add(Arrays.asList(nextRecord)); //rows is a list of list
  //do whatever you want to do
}