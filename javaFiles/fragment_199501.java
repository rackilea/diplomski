public class PrimeNumber {    
  /**
   * @param args the command line arguments
   */
  private static boolean prime = true;
  private static int count =  20;

  public static void main(String[] args) {

    for (int i = 2; count>0; i++) {
      for (int j = 2; j < i/2 + 1; j++) {
        if (i % j == 0) {
          prime = false;
          break;
        } else {
          prime = true;
        }
      }
      if (prime) {
        System.out.println(i + " is a Prime:");
        count--;
      }    
    }    
  }    
}