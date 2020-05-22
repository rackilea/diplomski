FileReader fr;
    try {
      fr = new FileReader("pi.txt");
    } catch (FileNotFoundException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } 
    //and

try {
  String zeile1 = br.readLine();
} catch (IOException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
}