boolean quit = false;
while(!quit) {
    System.out.print("Enter Something:");
    Scanner sc1 = new Scanner(System.in);
    String input = sc1.nextLine();
    if(input.compareToIgnoreCase("quit") == 0) {
        quit = true;
        continue;
    }
    System.out.println("You entered " + input);
}