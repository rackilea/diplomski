public static void main(String[] args) {
  for (int b = 999; b >= 100; b--) {
    for (int a = 999; a >= 100; a--) {
      int sum = 0;
      int num = (a * b);
      int temp = num;

      while (num > 0) {
        int remainder = num % 10;
        sum = (sum * 10) + remainder;
        num = num / 10;
      }

      if (temp == sum) {
        System.out.println(temp);
      }
    }
  }
}