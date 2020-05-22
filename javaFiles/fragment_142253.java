int evenNumber;
Scanner keyboard = new Scanner(System.in);
System.out.println("Enter an integer:");
int firstNum = keyboard.nextInt();

System.out.println("Enter another integer larger than the first one:");
int secondNum = keyboard.nextInt();

System.out.println();

int mod = firstNum % 2;
int sum = 0;

if (mod != 0) {
    firstNum++;
}

evenNumber = firstNum;
System.out.print("Even numbers: ");
while (evenNumber <= secondNum) {
    System.out.print(evenNumber + " ");
    evenNumber += 2;
}

System.out.println();

System.out.print("Sum of even numbers: ");

while (firstNum <= secondNum) {
    sum += firstNum;
    firstNum += 2;
}
System.out.println(sum);