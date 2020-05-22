//move this stuff into the do/while
Scanner userInput = new Scanner(System.in);
System.out.print("You can view any of the following shapes: ");
System.out.print("\n1 Square");
System.out.print("\n2 Right-angle Triangle");
System.out.print("\n3 Pyramid");
System.out.print("\n4 Hourglass");
System.out.print("\n5 Diamond");

System.out.print("\nEnter a integer to choose a shape: ");
String shape = userInput.nextLine();

System.out.print("\nEnter the height of the shape: ");
int inputOne = userInput.nextInt();

System.out.print("Enter a character: ");
char ch = userInput.next().charAt(0);
System.out.println("\n");

do {
    ^^^^ move that stuff in here
}while(playAgain())