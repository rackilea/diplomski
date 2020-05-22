public class FirstTenTest {
  public static void main (String... args) {
    String myString = "Внасяне от осигурителя на осигурителните вноски за държавното обществено осигуряване и допълнително задължително пенсионно осигуряване върху начислени, но неизплатени възнаграждения или върху неначислени възнаграждения, отнасящи се за труд, положен през месец Март 2012 г. (първият работен ден след 30 Април 2012 г. е 02 Май 2012 г.)";

    System.out.println(firstTenWords(myString));
  }

  public static String firstTenWords(String input) {
    StringBuilder sb = new StringBuilder();
    int spaceCount = 0;
    for(char c : input.toCharArray()) {
      if (c == ' ') spaceCount++;
      if (spaceCount == 10) break;
      sb.append(c);
    }
    return sb.toString();
  } 
}