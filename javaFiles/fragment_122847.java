import java.util.*;

class AsString {
  public static void main(String[] args) {
    Scanner keyboardIn = new Scanner(System.in);
    int downPayment;

    for(int i=0; i<10000000; i++) {
      String input = keyboardIn.next();
      if (input.startsWith("$")) input = input.substring(1);
      downPayment = Integer.parseInt(input);
    }
  }
}