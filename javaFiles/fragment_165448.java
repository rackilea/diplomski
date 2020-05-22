Path path = Paths.get("/path/to/data3.csv");
 try (CSVParser parser = CSVFormat.DEFAULT.parse(Files.newBufferedReader(path));) {
     for (CSVRecord csvRecord : parser) {
         System.output.println( "### " + csvRecord.get(0) + " " + csvRecord.get(1) + "\n";
     }
 }