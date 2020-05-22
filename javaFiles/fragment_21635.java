// USAGE: java MyProcessor arg1 arg2 myfiles*.txt

public static void main(String[] args) throws Exception {
  String arg1 = args[0];
  String arg2 = args[1];

  // looping over all input files
  for (int i = 2; i < args.length; i++) {
    File inputFile = new File(args[i]).getCanonicalFile();
    BufferedReader in = new BufferedReader(new FileReader(inputFile)); 
    // ...
  }
}