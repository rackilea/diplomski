Scanner input = new Scanner(System.in);
System.out.println("Input numbers, 0 for stop!");
int number = input.nextInt();
int average = number;
int counter = 1;
while (number != 0) {
    average= (average * number + number) / (counter + 1);
    counter++;
    number = input.nextInt();
}
System.out.println("Average is: " + average);