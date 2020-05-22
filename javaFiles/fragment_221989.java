Scanner input = new Scanner(System.in);
long previous = Long.MIN_VALUE;
while (true) {
     System.out.println("Type some numbers and dont forget to click enter after each number");
     int number = input.nextInt();
     if (previous == number) {
          System.out.println("yeay");
          break;
     }
     previous = number;
}