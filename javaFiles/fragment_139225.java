public class SecretCode {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    while (t>0) {
      t--;
      char chars[] = scanner.next().toCharArray();
      String msg = scanner.next();
      StringBuilder builder = new StringBuilder();
      for (int i=0; i<msg.length();) {
        String number = msg.substring(i, i+2);
        Integer num = Integer.parseInt(number);
        builder.append(chars[num-1]);
        i = i+2;
      }
      System.out.println(builder.toString());
    }
  }
}