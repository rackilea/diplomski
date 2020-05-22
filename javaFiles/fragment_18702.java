class Test {
  public static void main(String[] args) {
    int a = 5324;
    int b = 5;

    int fixedpointresult = 10*a/b;
    int lastDigit = fixedpointresult % 10;

    System.out.println(lastDigit);
  }
}