public int countStringInFile(String stringToLookFor, String fileName){
  int count = 0;
  try{
    FileInputStream fstream = new FileInputStream(fileName);
    DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    while ((strLine = br.readLine()) != null)   {
      int startIndex = strLine.indexOf(stringToLookFor);
      while (startIndex != -1) {
        count++;
        startIndex = base.indexOf(stringToLookFor, 
                                  startIndex +stringToLookFor.length());
      }
    }
    in.close();
  }catch (Exception e){//Catch exception if any
    System.err.println("Error: " + e.getMessage());
  }
  return count;
}