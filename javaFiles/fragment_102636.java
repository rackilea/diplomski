public static void main(String[] args){
  readFile();
}

public static void readFile() {
  try {
    Scanner input = new Scanner(new File("file.txt"));
    // ...
  } catch (FileNotFoundException e) {
    // Do something with `e` or handle it accordingly.
  }
}