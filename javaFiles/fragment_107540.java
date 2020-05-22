String characters = "Monkey Robot Pirate Ninja Zombie";

yourMove = "";
while (yourMove.equals("")) {
    System.out.println("What do you choose? --> "); 
    yourMove = input.nextLine().toLowerCase();
    if (yourMove.equals("quit")) { 
        System.out.println("Thanks for playing. Bye Bye"); 
        System.exit(0); 
    }
    if (!characters.toLowerCase().contains(yourMove) || yourMove.equals("")) {
        System.out.println("You entered an invalid Game Character! Try again...\n"); 
        continue;
    }
}