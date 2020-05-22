private static void readData() throws FileNotFoundException {  
  java.io.File file = new java.io.File("Zines.txt");  
  Scanner sc = new Scanner(file);  
  while (sc.hasNextLine()) {  
    String line = sc.nextLine();  
  }  
  sc.close();  
}