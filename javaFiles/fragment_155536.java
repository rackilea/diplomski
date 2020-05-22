System.out.print("Enter a number or ctrl + z when you are done: ");
do {
  data[count++] = input.nextInt();
  System.out.print("Enter a number or ctrl + z when you are done: ");
}
while (input.hasNextDouble());