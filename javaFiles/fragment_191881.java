class Main {
  public static void main(String[] args) {
    int n = 58347;
    while (n >= 100) {
      n /= 10;
    }
    System.out.println(n % 10); // prints 8
  }
}