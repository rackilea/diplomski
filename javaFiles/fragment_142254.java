Scanner keyboard = new Scanner(System.in);
System.out.println("Enter an integer:");
int firstNum = keyboard.nextInt();
System.out.println("Enter another integer larger than the first one:");
int secondNum = keyboard.nextInt();
int total = 0;
System.out.print("Even Numbers: ");
while (firstNum <= secondNum) {
    if (firstNum % 2 == 0) {
        System.out.print(firstNum + " ");
        total += firstNum;
    }
    firstNum++;
}
System.out.println("\nSum: " + total);