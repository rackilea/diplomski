// Declare variables 
String INput = "";
Random rand = new Random();
int output = 0;

do{
    // Ask user
    System.out.println("Enter (shoot, reload , or block) ");
    INput = input.nextLine();

    // Computer decision
    output = rand.nextInt(3) + 1;

    ...