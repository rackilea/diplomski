CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
String [] nextLine;
String searchWord = ".*\\d+.*"; // field contains integer?
while ((nextLine = reader.readNext()) != null) {
   for (String field: nextLine) {
      if (field.matches(searchWord)) {
         // matched word...
      }
   }
}