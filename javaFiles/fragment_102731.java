public class CheckBracketsPairs  {
  public static void main(String[] args) {
    validateExpression(")((5+9)-2)");
    validateExpression("(2*6)-1)*(2^2)");
    validateExpression("(8^2)");
    validateExpression("(5+8^2))");  // This line computing?
    validateExpression("(5+8^2)(");  // Why is this line NOT computing?
  }

  public static void validateExpression(String s) {

    // MY CODES BELOW  
    int count = 0;
    char open = '(';
    char close = ')';

    for (int i = 0, n = s.length(); i < n; i++) {
      char c = s.charAt(i);

      if(c == open) {
        count++;
      }

      if (c == close) {
        count--;
        // If statement to check for closed brackets
        if (count < 0) {
          System.out.println("\nExpression:  " + s + "  -Bracket is NOT balanced");
          break;
        }
      }
    } 

    if (count == 0) {
      System.out.println("\nExpression:  " + s + "   -Bracket is balanced");
    }
  }    
}