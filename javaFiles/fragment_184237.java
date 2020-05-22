class Test73 {
  public static final int MAX_GUESSES = 10;
  public static final int NB_COLUMNS= 4;
  private String guess[][];
  private String answer[];
  private String gotIt;

  public static void main(String[] args) {
    Test73 t = new Test73();
  }

  public Test73() {
    gotIt = " ";   // should probably be an array? 
    guess = new String[MAX_GUESSES][NB_COLUMNS];
    answer = new String[NB_COLUMNS];
    printBoard();
  }

  public void printBoard() {
    System.out.println(" _______________________");
    System.out.println(   // assumes gotIt to be of length 1
      "|  " + gotIt +
      "  |  " + gotIt +
      "  |  " + gotIt +
      "  |  " + gotIt +
      "  |  ");
    System.out.println(" _______________________    ____");
    for (int j = 0; j < MAX_GUESSES; j++) {
      for (int k = 0; k < NB_COLUMNS; k++) {
        guess[j][k] = "    ";
        answer[k] = " ";
      }
      System.out.println(
        "| " + guess[j][0] +
        "| " + guess[j][1] +
        "| " + guess[j][2] +
        "| " + guess[j][3] +
        "|==|" + answer[0] +
        answer[1] +
        answer[2] +
        answer[3] + "|");
      System.out.println(" _______________________    ____");
    }
  }
}