public static void parseFile() throws IOException, ParseException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("inputFileName.txt")));
    Map<Integer, Date> integerDateMap = new HashMap<>(); // Map to put data
    SimpleDateFormat sdfmt2= new SimpleDateFormat("dd/MM/yyyy"); // date format
    String line = null;
    line = bufferedReader.readLine(); // neglect first line
    while((line = bufferedReader.readLine())!= null){
         String[] split = line.split("   ");
         integerDateMap.put(Integer.parseInt(split[0]),sdfmt2.parse(split[1]));
    }
    System.out.println(integerDateMap); // print to check
}