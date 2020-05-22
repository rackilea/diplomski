public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  StringBuilder sb = new StringBuilder();
  for (int counter = 0; counter < 5; counter++) {
    System.out.print("Input an integer between 1 and 30: ");
    System.out.flush();
    int value = input.nextInt();

    while (value < 1 || value > 30) {
      System.out.print("Input an integer between 1 and 30: ");
      System.out.flush();
      value = input.nextInt();
    }
    for (int i = 0; i < value; i++) {
      sb.append("*");
    }
    sb.append("\n");
  }
  System.out.println(sb.toString());
  System.out.flush();
  System.exit(0);
}