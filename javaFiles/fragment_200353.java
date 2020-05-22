public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while (!scan.hasNextInt()) {
      System.out.println("Input is not a number.");
      scan.nextLine();
    }
    int number = scan.nextInt();
  }