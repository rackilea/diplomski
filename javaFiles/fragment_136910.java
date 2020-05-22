public class Test
{
  static final char[] CODE_LETTERS = {'T', 'R', 'W', 'A', 'G'};

  public static void main(String[] args) throws Exception
  {
    System.out.println(CODE_LETTERS[0]); // T
    CODE_LETTERS[0] = 'x';
    System.out.println(CODE_LETTERS[0]); // x
  }
}