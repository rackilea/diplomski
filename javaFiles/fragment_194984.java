public static void main(String[] args) {
  int x1 = 3;
  int x2 = -11;

  int x1IntegerRotated = Integer.rotateLeft(x1, 2);
  int x1SelfRotated = rotateLeft(x1, 2);
  System.out.printf("x1 = %d(%s)%n",               x1,               printIntBitwise(x1));
  System.out.printf("x1IntegerRotated = %d(%s)%n", x1IntegerRotated, printIntBitwise(x1IntegerRotated));
  System.out.printf("x1SelfRotated = %d(%s)%n",    x1SelfRotated,    printIntBitwise(x1SelfRotated));

  System.out.println();

  int x2IntegerRotated = Integer.rotateLeft(x2, 2);
  int x2SelfRotated = rotateLeft(x2, 2);
  System.out.printf("x2 = %d(%s)%n",               x2,               printIntBitwise(x2));
  System.out.printf("x2IntegerRotated = %d(%s)%n", x2IntegerRotated, printIntBitwise(x2IntegerRotated));
  System.out.printf("x2SelfRotated = %d(%s)%n",    x2SelfRotated,    printIntBitwise(x2SelfRotated));
}

private static int rotateLeft(int value, int distance) {
  int mask = (1 << distance) - 1;
  int leftPart = (value << distance) & (~mask);
  int rightPart = (value >> (32 - distance)) & (mask);

  int result = leftPart | rightPart;

  return result;
}

private static String printIntBitwise(int a) {
  StringBuilder sb = new StringBuilder();

  for(int i = 1; i <= 32; i++) {
    sb.append(Math.abs((a & (1 << (32 - i))) >> (32 - i)));
  }

  return sb.toString();
}