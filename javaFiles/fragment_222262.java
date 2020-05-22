int numberOfPlayers;
Scanner input = new Scanner(System.in);
System.out.println("Enter number of players:");
numberOfPlayers = input.nextInt();
input.nextLine();
String[] arrayOfPlayers = new String[numberOfPlayers];
for (int i = 1; i <= numberOfPlayers; i++) {
  System.out.println("Enter name for Player " + i + ":");
  arrayOfPlayers[i-1] = input.nextLine();
}
// print list
for (String player : arrayOfPlayers) {
    System.out.println(player);
}

input.close();