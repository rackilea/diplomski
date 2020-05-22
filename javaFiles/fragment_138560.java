CSVReader reader = new CSVReader(new FileReader("yourfile.csv"), '\t');
String [] nextLine;
while ((nextLine = reader.readNext()) != null) {
    // nextLine[] is an array of values from the line
    System.out.println(nextLine[0] + nextLine[1] + "etc...");
}