import java.util.Scanner;

class ManyDiamond {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the height: ");
    int h = sc.nextInt();
    System.out.print("How many diamonds: ");
    int a = sc.nextInt();
    sc.close();
    int lCurr = 0; // CHANGED
    char[] letter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
        'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    // top of diamond
    for (int n = 1; n <= h; n++) { // which row
      for (int j = 1; j <= a; j++) { // how many diamond
        for (int k = 1; k <= h - n; k++) { // left space
          System.out.print(" ");
        }
        for (int m = 1; m <= 2 * n - 1; m++) { // star
          if ((m == 1 || m == 2 * n - 1)) {
            System.out.print("*");
          } else if ((n >= 3) && (m == 3) || (m == 2 * n - 3)) {
            System.out.print("O");
          } else {
            System.out.print(" ");
          }
        }
        for (int space1 = 1; space1 <= -n + h; space1++) { // right space
          System.out.print(" ");
        }
        if (n == h && j != a) { // CHANGED
          System.out.print(String.valueOf(letter[lCurr++]) + String.valueOf(letter[lCurr++]) + String.valueOf(letter[lCurr++])); // CHANGED
        } else {
          System.out.print("   "); // CHANGED
        }
      }
      System.out.println("");
    }
    int lh = h - 1; // bottom row of diamond
    for (int i = 1; i <= lh; i++) { // which row
      for (int j = 1; j <= a; j++) { // how many diamonds
        for (int space = 1; space <= i; space++) { // left space
          System.out.print(" ");
        }
        for (int star = -2 * i + (2 * h - 1); star > 0; star--) { // star
          if ((star == 1) || (star == -2 * i + (2 * h - 1))) {
            System.out.print("*");
          } else if ((i >= 1 && (star == 3) || (star == -2 * i + (2 * h - 1) - 2))) {
            System.out.print("O");
          } else {
            System.out.print(" ");
          }
        }
        for (int space2 = 1; space2 <= i; space2++) { // right space
          System.out.print(" ");
        }
        System.out.print("   "); // CHANGED
      }
      System.out.println();
    }
  }
}