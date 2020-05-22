public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  // values holds room for 5 inputs
  int[] values = new int[5];

  for (int counter = 0; counter < values.length; counter++) {
    System.out.print("Input an integer between 1 and 30: ");
    System.out.flush();
    int value = input.nextInt(); // <-- declare value here.

    while (value < 1 || value > 30) {
      System.out.print("Input an integer between 1 and 30: ");
      System.out.flush();
      value = input.nextInt();
    }
    values[counter] = value; // <-- store it in the values array.
  }
  // Use the for each operator to iterate over the value(s)...
  for (int value : values) {
    // print the asterisks based on value
    for (int i = 0; i < value; i++) {
      System.out.print("*");
    }
    System.out.println();
  }
  System.out.flush();
  System.exit(0);
}