public class Hashcode {
  static final String ALPHABET = "acegikmnoprstuvy";

  public static long hash(String s) {
    long h = 7;
    for (int i=0; i<s.length(); i++) {
      h = (h * 37 + ALPHABET.indexOf(s.charAt(i)));
    }
    return h;
  }

  public static String unhash(long n) {
    String result = "";
    while (n>7) {
      result = ALPHABET.charAt((int)(n%37)) + result;
      n = n/37;
    }
    if (n != 7) {
      System.err.println("Error, hash parity incorrect.");
      System.exit(1);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(hash("reports"));
    System.out.println(unhash(690336378753L));
    System.out.println(unhash(932246728227799L));
    System.out.println(hash("mymitsapp"));
  }
}