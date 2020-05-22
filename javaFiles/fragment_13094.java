Random random = new Random();
Scanner scan = new Scanner(System.in);

final int SENTINEL = -1;
int number1;
int number2;
int product = 0;

while (product != SENTINEL) {
  number1 = random.nextInt(13);
  number2 = random.nextInt(13);
  int answer = number1 * number2;

  System.out.print("What is " + number1 + " X " + number2 + "? > ");
  product = scan.nextInt(); 

  if (product == answer) {
    System.out.println("Correct! " + number1 + " X " + number2 + " = " + answer);
  } else { 
    System.out.println("Wrong " + number1 + " X " + number2 + " = " + answer);
  }
}