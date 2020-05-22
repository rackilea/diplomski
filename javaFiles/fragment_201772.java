package foo;

import com.twitter.util.Eval;

public class Test {
  public static void main(String[] args) {
    final Eval eval = new Eval();
    final int result = eval.apply("3 + 4", true);
    System.out.println("Result: " + result);
  }
}