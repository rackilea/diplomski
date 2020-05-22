public static ArrayList<Object[]> readData(String FilePath) throws IOException {
    ArrayList<Object[]> Myarr= new ArrayList<Object[]>();
    String UserDir= System.getProperty("user.dir");
    CSVReader CSVfileread= new CSVReader(new FileReader(UserDir+ FilePath), '\t');

    CSVfileread.readNext();
    String[] nextLine = null;

    while ((nextLine = CSVfileread.readNext()) != null){
        Myarr.add(new Object [] {nextLine});
    }
    System.out.println("Data file has been read");
    CSVfileread.close();
    return Myarr;    
}