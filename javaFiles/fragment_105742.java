public class LargestNumberFinder {

  public static final String FILENAME = "C:\\Java\\Test.txt";

  public static void main(String[] args) throws IOException {
      BufferedWriter fout = new BufferedWriter(new FileWriter(FILENAME, true));
      Scanner in = new Scanner(System.in);
      System.out.print("Skriv in tre tal: ");
      int x = in.nextInt();
      int y = in.nextInt();
      int z = in.nextInt();
      fout.write(x + " " + y + " " + z);
      fout.newLine();
      fout.flush();

      BufferedReader fin = new BufferedReader(new FileReader(FILENAME));
      String s = fin.readLine();
      System.out.println(s);

      int largest = getLargestNumberFromFile(FILENAME);
      System.out.println("The largest number is: " + largest);
  }

  private static int getLargestNumberFromFile(String filename) throws FileNotFoundException {
      int largest = -1;
      Scanner scanner = new Scanner(new File(filename));
      scanner.useDelimiter(" |[\\r\\n]+");
      while(scanner.hasNext()) {
          int currentNumber = scanner.nextInt();
          if (currentNumber > largest) {
              largest = currentNumber;
          }
      }
      scanner.close();

      return largest;
  }