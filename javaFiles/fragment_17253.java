import java.util.Scanner;

class Test {
  final static Scanner scanner = new Scanner(System.in);

  public static String getInputFileName() {
    System.out.print("Enter input file: ");
    return scanner.nextLine();
  }

  public static String getOutputFileName() {
    System.out.print("Enter output file: ");
    return scanner.nextLine();
  }

  public static void processTickets(String inputFileName, String outputFileName) {
    /* All your processing code here */
  }

  public static void main(String[] args) {
    processTickets(getInputFileName(), getOutputFileName());
  }
}