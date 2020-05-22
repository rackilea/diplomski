public class CharVsShort {
  public static void main(String[] args) throws Exception {
    short ffShort = (short)0xFFFF;
    char ffChar = (char)0xFFFF;

    System.out.println("all-1s-short = " + (int)ffShort);
    System.out.println("all-1s-char  = " + (int)ffChar);
  }
}