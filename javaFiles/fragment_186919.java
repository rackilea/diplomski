public class st {

  private static Scanner stdin = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("First call");
    getInt("Enter first int (1-10): ");
    System.out.println("Second call");
    getInt("Enter second int (1-10): ");
  }

  /**
   * Reads an integer number from the keyboard.
   *
   * @param  prompt    the string to display as a prompt.
   * @return           the integer number entered at the keyboard.
   */
  public static int getInt(String prompt) {
    System.out.print(prompt);
    int val = stdin.nextInt();

    stdin.close();
    return(val);
  }
}

// END