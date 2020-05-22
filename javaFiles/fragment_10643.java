public static void main(...) {
  ...
  System.out.println("\n\nFibonacci series for " + number +" numbers : ");
  fibonacciLoop(i);
}
static void fibonacciLoop(int number) {
  int fibo1 = 1, fibo2 = 1, sum = 0, average = 0, fibonacci;
  for (int i = 1; i <= 2 && i <= number; i++) {
    System.out.print("1 ");
    sum += 1;
  }
  for (i = 3; i <= number; i++) {
    fibonacci = fibo1 + fibo2;
    System.out.print(fibonacci + " ");
    fibo1 = fibo2; fibo2 = fibonacci;
    sum += fibonacci;
  }
  System.out.println("  average = " + (float)sum/number)
}