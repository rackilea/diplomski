public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.println("Enter the first number: ");
      double number = input.nextDouble();

      System.out.println("Enter the second number: ");
      double number2 = input.nextDouble();

      double total = Operations.add(number, number2);
      System.out.println(total);

      do {
        System.out.println("Enter the number again: ");
        number2 = input.nextDouble();
        total = Operations.add(total, number2);
        System.out.println(total);
      } while (input.hasNextDouble());

      System.out.println("Exit.");
    }