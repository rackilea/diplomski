System.out.println("Are you ready for a quiz?\n1.yes\n2.no");
String input;
do {
    input= scanner.nextLine();
    if (input.equals("2")) {
       System.out.println("Maybe next time!");
       System.exit(0);
    } 
    System.out.println("Invalid input. Try again\n");             
} while (!input.equals("1"));
System.out.println("Okay! good luck!\n");