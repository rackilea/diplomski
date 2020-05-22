public static void main(String[] args) {
    int x = twiceAsOld(25, 5);
    System.out.println(x);
  }

  public static int twiceAsOld(int dadYears, int sonYears) {
    return 2*sonYears - dadYears;

  }