CSVReader csvfile = new CSVReader("FilePath\\.csv");

    String[] csvdata = csvfile.readnext(); // To read the row one by one
// Read all row from csv     
List<String[]> csvdata1 = csvfile.readAll(); //To Read all data from csv file
     String[] csvdata = csvdata1.get(0);//Read first row