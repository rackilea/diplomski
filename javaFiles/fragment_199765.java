// from your main method
String fname = "data.txt";
readData (fname);

// the method being called
public static void readData (String data[][]){           
   BufferedReader br = new BufferedReader(new FileReader(data));