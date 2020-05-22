public static void main(String[] args) throws Exception {
    final String splitBy = ";";
    int totalValue = 0;
    int columnCount = 0;
    final BufferedReader br = new BufferedReader(new FileReader("C:/test/bank-full.csv"));
    String line;
    // Throw away headers.
    line = br.readLine();
    while ((line = br.readLine()) != null)
    {
         String[] splitCSV = line.split(splitBy);
         if (!splitCSV[9].equals(""))
         {
             totalValue += Integer.parseInt(splitCSV[9]);
             columnCount++;
         }
    }
    br.close();
    System.out.println("Average is " + totalValue / columnCount);
}