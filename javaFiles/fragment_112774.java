do {
      System.out.println("Enter the number again: ");
      number2 = input.nextDouble();
      total = Operations.add(total, number2);
      System.out.println(total);
    } while (input.hasNextDouble());