public static void main(String[] args){
  try {
    readFile();
  } catch (FileNotFoundException e) {
    // Do something with `e`
  }
}

public static void readFile() throws FileNotFoundException {
  Scanner input = new Scanner(new File("file.txt"));
  // ...
}